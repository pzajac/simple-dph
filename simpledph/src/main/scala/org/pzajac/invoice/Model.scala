
package org.pzajac.invoice

import org.joda.time._
import org.joda.time.format.DateTimeFormat

class Country (val name: String) {
  def isEuNotCzech : Boolean = true
}

object czechCountry extends Country("Czech") {
  override def isEuNotCzech = false
} 

object Env {
  val dateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd")
  
}

class Address (val street: String, val town: String, val country: Country) 

class TaxId (id : String, dph : Boolean)

class Company(val name: String,
              val id: String,
              val address: Address,
              val taxId: TaxId) {
  
    def shortDesc = name
    }


  object DphType extends Enumeration {
    type DphType = Value
    val LowDph, HightDph, NoDph = Value
  }
  
import DphType._
  
abstract class InvoiceType ;
object IncommingInvoice extends InvoiceType
object OutgoingInvoice extends InvoiceType

class Amount(val baseValue: Float,val dphValue: Float,val total: Float)

class Invoice (val id: String,
               val company: Company,
               val invoiceType: InvoiceType,
               val invoiceDate: DateTime,
               val records: Map[DphType, Amount],
               val total: Float,
               val shortDesc: String
               
) {
   def isToEu : Boolean = company.address.country.isEuNotCzech

   def totalDph: Float = records.values.map (_.dphValue).sum
   def totalBase: Float = records.values.map (_.baseValue).sum
   def recordsWithDefault: Map[DphType, Amount] = records.withDefaultValue(new Amount(0, 0, 0))
}
  
class EuOutgoingInvoices (val companyToInvoinces : Map[Company,List[Invoice]])

/**
 * Date interval for DPH report.
 */
class DphIntervalBuilder {
	def createForQuarter(year : Int, quarter : Int) : Interval = {
	  val first = new DateTime(year, (quarter - 1)*3 + 1, 1, 1, 1) 
	  new Interval(first.getMillis(), first.plusMonths(3).getMillis())
	}
	
	def createForMonth(year: Int, month: Int) : Interval = {
	  val first = new DateTime(year, month, 1, 0, 0) 
	  new Interval(first.getMillis(), first.plusMonths(1).getMillis())
	}
}


class DphReport(myCompany: Company,
                interval: Interval,
                allInvoices: List[Invoice]) {
  
  def invoices: List[Invoice] = allInvoices.filter(invoice => interval.contains(invoice.invoiceDate))
  /**
   * all incomming invoices for dph report
   */
  def incommingInvoices : List[Invoice] = invoices.filter(_.invoiceType == IncommingInvoice)
  /**
   * all outgoing resources for dph report
   */
  def outgoingInvoices : List[Invoice] = invoices.filter(_.invoiceType == OutgoingInvoice)
  /**
   * all invoices for "souhrnne hlaseni"
   */
  def euOutgoingInvoices: EuOutgoingInvoices = {
    val euInvoices = outgoingInvoices.filter(_.isToEu)
    new EuOutgoingInvoices(euInvoices.groupBy(_.company))
  }
  /** @return all DphTypes */
  def usedDphTypes(invoicesx: List[Invoice]): Set[DphType] = Set() ++ invoicesx.map(_.records.keys).flatten
  
  /**
   * Summarizes records for DphType.
   */
  def totalAmount(invoicesx: List[Invoice], dphType: DphType): Amount = {
    val amounts: List[Amount] = invoicesx.map(_.recordsWithDefault(dphType))
    amounts.foldLeft(new Amount(0, 0, 0)) ((a1, a2) => new Amount(a1.baseValue + a2.baseValue,
        a1.dphValue + a2.dphValue,
        a1.total + a2.total))
  }
  
  def summaryReport : String = { 
    val noEuInvoince: List[Invoice] = incommingInvoices.filterNot(_.isToEu)
    val usedDphs = usedDphTypes(noEuInvoince)
    val table = for (dph <- usedDphs) yield createSubSummary(dph, noEuInvoince)
    val rows = table.map(_.map(_.mkString(" ")).mkString("\n"))
    rows.mkString("\n")
  }
  
  /**
   * Create summary for an DphType.
   */
  private def createSubSummary(dph : DphType, invoices : List[Invoice]) : List[List[String]] = {
    val records: List[List[String]] = for (invoice <- invoices 
         if(invoice.records.contains(dph))) yield {
             val amount: Amount = invoice.records(dph)
             // datum plneni
             List[String](Env.dateFormatter.print(invoice.invoiceDate),
             // zauctovani
               "N/A", 
             // cislo dokladu
               invoice.id, 
             // popis
               invoice.shortDesc,
             // zakladDane
               amount.baseValue.toString(),
             // DPH
               amount.dphValue.toString(),
             // Celkem CZK
               amount.total.toString(), 
             // Partner/ DIC
              invoice.company.shortDesc
             )
         }
         List[String]("Datum plneni", "Cislo dokladu", "Popis", "Zaklad Dane", "DPH", "Celkem CZK", "Partner/DIC") ::
         records
  }
    
}
  
  
