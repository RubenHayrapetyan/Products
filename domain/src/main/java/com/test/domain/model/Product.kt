package com.test.domain.model

data class Product(
  val id: Long,
  val name: String,
  val time: Long,
  val tags: List<String>,
  val amount: Int
)
