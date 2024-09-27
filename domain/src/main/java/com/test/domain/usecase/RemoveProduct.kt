package com.test.domain.usecase

interface RemoveProduct {
  suspend operator fun invoke(productId: Long)
}