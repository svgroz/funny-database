package org.svgroz.funny_database.datatypes

final case class TableMetadata(name: String, keys: Seq[CellType], pageSize: Long)

final case class KeyMetadata(name: String, cellType: Cell)