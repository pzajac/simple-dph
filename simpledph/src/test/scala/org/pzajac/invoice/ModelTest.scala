package org.pzajac.invoice

import org.junit._
import Assert._
import org.joda.time._

@Test
class ModelTest {

   @Test
  def example {

    new SimpleModel {
      assertFalse(ini1.isToEu)

      val milis = date1.getMillis();
      val intervalBuilder = new DphIntervalBuilder()
      val dphReport = new DphReport(myCOmpany, intervalBuilder.createForQuarter(2014, 4), List(ini1, ini2))
      assertEquals("incomming invoices", 2, dphReport.incommingInvoices.invoices.size)
      println(dphReport.summaryReport)
      println("ok")
    }
  }
}


