package org.svgroz.funny_database.datatypes

import org.svgroz.funny_database.datatypes.Cell.{DoubleCell, LongCell, NoneCell, StringCell}

class RowComparatorTest extends DatatypesTestSpec {
  "RowComparator with equal rows" should "return 0" in {
    val source = Row(Seq(LongCell(0), DoubleCell(0), StringCell("0"), NoneCell))
    val target = Row(Seq(LongCell(0), DoubleCell(0), StringCell("0"), NoneCell))
    assertResult(0) {
      RowComparator.compare(source, target)
    }
  }

  "RowComparator with different rows length" should "return 0" in {
    val source = Row(Seq(LongCell(0), DoubleCell(0), StringCell("0"), NoneCell))
    val target = Row(Seq(LongCell(0), DoubleCell(0)))
    assertResult(0) {
      RowComparator.compare(source, target)
    }
  }

  "RowComparator with different rows" should "return < 0" in {
    val source = Row(Seq(LongCell(0), DoubleCell(0), LongCell(0)))
    val target = Row(Seq(LongCell(0), DoubleCell(1), LongCell(0)))
    assert(0 > RowComparator.compare(source, target))
  }
}
