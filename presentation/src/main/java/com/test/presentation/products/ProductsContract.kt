package com.test.presentation.products

import com.test.domain.model.Product

class ProductsContract {

  sealed class ProductsEvent {
    data class OnSearchEvent(val query: String) : ProductsEvent()
    data class OnRemoveProductEvent(val productId: Long) : ProductsEvent()
    data class OnUpdateProductAmountEvent(val productId: Long, val newAmount: Int) : ProductsEvent()
  }

  data class ProductsState(
    val products: List<Product>? = null,
    val searchQuery: String = ""
  )
}