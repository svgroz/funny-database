package org.svgroz.funny_database.datatypes

import org.svgroz.funny_database.datatypes.Cell.{DoubleCell, LongCell, NoneCell, StringCell}

sealed abstract class Cell

sealed trait CellType {
  def isSupported(cell: Cell): Boolean
}

object Cell {
  final case class LongCell(value: Long) extends Cell

  final case class DoubleCell(value: Double) extends Cell

  final case class StringCell(value: String) extends Cell

  final case object NoneCell extends Cell
}

object CellType {
  final case object LongCellType extends CellType {
    override def isSupported(cell: Cell): Boolean = cell match {
      case LongCell(_) => true
      case NoneCell => true
      case _ => false
    }
  }

  final case object DoubleCellType extends CellType {
    override def isSupported(cell: Cell): Boolean = cell match {
      case DoubleCell(_) => true
      case NoneCell => true
      case _ => false
    }
  }

  final case object StringCellType extends CellType {
    override def isSupported(cell: Cell): Boolean = cell match {
      case StringCell(_) => true
      case NoneCell => true
      case _ => false
    }
  }
}
