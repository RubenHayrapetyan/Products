package com.test.domain.repository

import com.test.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepo {
  fun getAllProductsFromDb(): Flow<List<Product>>

  fun getSearchedProductsFromDb(query: String): Flow<List<Product>>

  suspend fun removeProduct(productId: Long)

  suspend fun updateProductAmount(productId: Long, newAmount: Int)
}