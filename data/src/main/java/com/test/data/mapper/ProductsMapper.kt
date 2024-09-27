package com.test.data.mapper

import com.test.data.model.ProductEntity
import com.test.domain.model.Product

fun ProductEntity.toProduct(): Product =
  Product(
    id = id,
    name = name,
    time = time,
    tags = tags,
    amount = amount
  )