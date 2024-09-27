package com.test.domain.usecase

import com.test.core.util.IODispatcher
import com.test.domain.repository.ProductsRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateProductAmountImpl @Inject constructor(
  private val productsRepo: ProductsRepo,
  @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : UpdateProductAmount {

  override suspend fun invoke(productId: Long, newAmount: Int) = withContext(ioDispatcher) {
    productsRepo.updateProductAmount(productId = productId, newAmount = newAmount)
  }
}