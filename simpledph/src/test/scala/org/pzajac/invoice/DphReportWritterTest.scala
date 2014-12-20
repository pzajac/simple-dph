package org.pzajac.invoice

import org.junit._
import Assert._
import org.joda.time._

class DphReportWritterTest {

   @Test
  def simpleDphWritter() {

    new SimpleModel {

      val myCompany = new Company("mycompany", "ico3", address3, taxId3)

      assertFalse(ini1.isToEu)

      val milis = date1.getMillis();
      val intervalBuilder = new DphIntervalBuilder()
      val dphReport = new DphReport(myCompany, intervalBuilder.createForQuarter(2014, 4), List(ini1, ini2))
      assertEquals("incomming invoices", 2, dphReport.incommingInvoices.invoices.size)
      println(dphReport.summaryReport)
      val xmlReport: DphReportWritter = new DphReportWritter(dphReport)
     println(xmlReport.generateXml)
    }
  }
}


