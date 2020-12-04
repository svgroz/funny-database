package org.svgroz.funny_database.datatypes

import org.svgroz.funny_database.datatypes.Cell.{DoubleCell, LongCell}
import org.svgroz.funny_database.datatypes.CellType.{DoubleCellType, LongCellType}

import scala.collection.mutable.ArrayBuffer

class TableTest extends DatatypesTestSpec {
  "Table metadata test" should "foobar" in {
    val metadata = TableMetadata("foo", Seq(LongCellType, DoubleCellType), 22)

    val table = Table(metadata, ArrayBuffer())

    table.addRow(Row(Seq(LongCell(2), LongCell(2))))

    assert(table.pages.size == 1)
    assert(table.pages.last.rows.size == 1)
    assert(table.pages.last.rows.last.cells.size == 2)
  }
}
