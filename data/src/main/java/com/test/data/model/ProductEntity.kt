package com.test.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.test.data.util.DataConstants

@Entity(tableName = DataConstants.PRODUCTS_TABLE_NAME)
data class ProductEntity(
  @PrimaryKey
  val id: Long,
  val name: String,
  val time: Long,
  val tags: List<String>,
  val amount: Int
)