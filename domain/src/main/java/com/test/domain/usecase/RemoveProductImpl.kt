package com.test.domain.usecase

import com.test.core.util.IODispatcher
import com.test.domain.repository.ProductsRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoveProductImpl @Inject constructor(
  private val productsRepo: ProductsRepo,
  @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoveProduct {

  override suspend fun invoke(productId: Long) = withContext(ioDispatcher) {
    productsRepo.removeProduct(productId = productId)
  }
}