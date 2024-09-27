package com.test.domain.usecase

import com.test.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface GetProductsFromDb {
  operator fun invoke(searchQuery: String = ""): Flow<List<Product>>
}