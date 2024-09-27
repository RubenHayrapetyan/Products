package com.test.domain.usecase

import com.test.core.util.IODispatcher
import com.test.domain.model.Product
import com.test.domain.repository.ProductsRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProductsFromDbImpl @Inject constructor(
  private val productsRepo: ProductsRepo,
  @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : GetProductsFromDb {

  override fun invoke(searchQuery: String): Flow<List<Product>> {
    return if (searchQuery.isEmpty()) {
      productsRepo.getAllProductsFromDb()
    } else {
      productsRepo.getSearchedProductsFromDb(query = searchQuery)
    }.flowOn(ioDispatcher)
  }
}