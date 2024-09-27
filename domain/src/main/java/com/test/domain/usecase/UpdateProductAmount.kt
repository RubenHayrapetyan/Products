package com.test.domain.usecase

interface UpdateProductAmount {
  suspend operator fun invoke(productId: Long, newAmount: Int)
}