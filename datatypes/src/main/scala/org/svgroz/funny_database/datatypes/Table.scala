package org.svgroz.funny_database.datatypes

import scala.Console.println
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

case class RowIsShorterThanKeys(row: Row, requiresKeysSize: Int) extends RuntimeException

case class Table(metadata: TableMetadata, pages: mutable.ArrayBuffer[Page] = ArrayBuffer()) {
  def addRow(row: Row): Unit = {
    val lastPage = pages.lastOption match {
      case Some(page) if page.rows.size < metadata.pageSize => page
      case _ =>
        val page = Page(ArrayBuffer())
        pages append page
        page
    }

    ((metadata.keys, row.cells) match {
      case (keys, cells) if cells.size >= keys.size => keys zip cells
      case _ => throw RowIsShorterThanKeys(row, metadata.keys.size)
    }).collectFirst {
      case (cellType, cell) if !cellType.isSupported(cell) => cell
    } match {
      case Some(cell) => throw new RuntimeException(s"$cell")
      case _ => lastPage.rows.append(row)
    }
  }
}
