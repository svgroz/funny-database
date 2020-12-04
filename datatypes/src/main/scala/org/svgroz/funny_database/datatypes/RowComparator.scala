package org.svgroz.funny_database.datatypes

import java.util.Comparator

object RowComparator extends Comparator[Row] {
  override def compare(source: Row, target: Row): Int = {
    (source.cells zip target.cells)
      .toStream
      .map { c => CellComparator.compare(c._1, c._2) }
      .collectFirst { case x if x != 0 => x }
      .getOrElse(0)
  }
}
