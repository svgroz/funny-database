package org.svgroz.funny_database.datatypes

import java.util.Comparator

import org.svgroz.funny_database.datatypes.Cell.{DoubleCell, LongCell, NoneCell, StringCell}

object CellComparator extends Comparator[Cell] {

  final case class IncomparableCells(source: Cell, target: Cell) extends RuntimeException

  override def compare(source: Cell, target: Cell): Int = {
    (source, target) match {
      case (LongCell(sourceValue), LongCell(targetValue)) => sourceValue.compareTo(targetValue)
      case (DoubleCell(sourceValue), DoubleCell(targetValue)) => sourceValue.compareTo(targetValue)
      case (StringCell(sourceValue), StringCell(targetValue)) => sourceValue.compareTo(targetValue)
      case (NoneCell, NoneCell) => 0
      case (_, NoneCell) => -1
      case (NoneCell, _) => -1
      case (_, _) => throw IncomparableCells(source, target)
    }
  }
}
