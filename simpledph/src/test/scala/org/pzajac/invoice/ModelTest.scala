package org.pzajac.invoice

import org.junit._
import Assert._
import org.joda.time._

@Test
class AppTest {

   @Test
  def example = {
    val country = czechCountry
    val address1 = new Address("Street1", "Town1",  country)
    val address2 = new Address("Street2", "Town2",  country)
    val address3 = new Address("Street3", "Town3",  country)
    val taxId1 = new TaxId("taxid1", true)
    val taxId2 = new TaxId("taxid2", true)
    val taxId3 = new TaxId("myTaxId", true)
    val company1 = new Company( "company1", "ico1", address1, taxId1)
    val company2 = new Company("company2", "ico2", address2, taxId2)
    val myCOmpany = new Company("mycompany", "ico3", address3, taxId3)
    
    
    val date1 = new DateTime(2014, 11, 17, 0, 0);
    val ini1 = new Invoice("i1", company1, IncommingInvoice, date1,
        Map(DphType.LowDph -> new Amount(10f, 2.2f, 12.2f)),
        33, "desc")
    val ini2 = new Invoice("i2", company2, IncommingInvoice, date1,
        Map(DphType.LowDph -> new Amount(20f, 4.4f, 24.4f)),
        33, "desc2")
    assertFalse(ini1.isToEu)
    
    val milis = date1.getMillis();
    val intervalBuilder = new DphIntervalBuilder()
    val dphReport = new DphReport(myCOmpany, intervalBuilder.createForQuarter(2014, 4), List(ini1, ini2))
    assertEquals("incomming invoices", 2, dphReport.incommingInvoices.invoices.size)
    println (dphReport.summaryReport)
    println("ok")
  }
}


