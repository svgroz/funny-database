package org.svgroz.funny_database.datatypes

import org.svgroz.funny_database.datatypes.Cell.{DoubleCell, LongCell, NoneCell, StringCell}
import org.svgroz.funny_database.datatypes.CellComparator.IncomparableCells

class CellComparatorTest extends DatatypesTestSpec {
  "CellComparator with equalise long cells" should "return 0" in {
    val source = LongCell(0)
    val target = LongCell(0)
    assertResult(0) {
      CellComparator.compare(source, target)
    }
  }

  "CellComparator with equalise double cells" should "return 0" in {
    val source = DoubleCell(0)
    val target = DoubleCell(0)
    assertResult(0) {
      CellComparator.compare(source, target)
    }
  }

  "CellComparator with equalise string cells" should "return 0" in {
    val source = StringCell("")
    val target = StringCell("")
    assertResult(0) {
      CellComparator.compare(source, target)
    }
  }

  "CellComparator with equalise none cells" should "return 0" in {
    val source = NoneCell
    val target = NoneCell
    assertResult(0) {
      CellComparator.compare(source, target)
    }
  }

  "CellComparator with none and long cells" should "return < 0" in {
    val source = NoneCell
    val target = LongCell(0)
    assert(CellComparator.compare(source, target) < 0)
  }

  "CellComparator with none and double cells" should "return < 0" in {
    val source = NoneCell
    val target = DoubleCell(0)
    assert(CellComparator.compare(source, target) < 0)
  }

  "CellComparator with none and string cells" should "return < 0" in {
    val source = NoneCell
    val target = StringCell("")
    assert(CellComparator.compare(source, target) < 0)
  }

  "CellComparator with long and double cells" should "throw IncomparableCells" in {
    assertThrows[IncomparableCells] {
      CellComparator.compare(LongCell(0), DoubleCell(0))
    }
  }

  "CellComparator with long and string cells" should "throw IncomparableCells" in {
    assertThrows[IncomparableCells] {
      CellComparator.compare(LongCell(0), StringCell(""))
    }
  }

  "CellComparator with double and long cells" should "throw IncomparableCells" in {
    assertThrows[IncomparableCells] {
      CellComparator.compare(DoubleCell(0), LongCell(0))
    }
  }

  "CellComparator with double and string cells" should "throw IncomparableCells" in {
    assertThrows[IncomparableCells] {
      CellComparator.compare(DoubleCell(0), StringCell(""))
    }
  }

  "CellComparator with string and long cells" should "throw IncomparableCells" in {
    assertThrows[IncomparableCells] {
      CellComparator.compare(StringCell(""), LongCell(0))
    }
  }

  "CellComparator with string and double cells" should "throw IncomparableCells" in {
    assertThrows[IncomparableCells] {
      CellComparator.compare(StringCell(""), DoubleCell(0))
    }
  }
}
