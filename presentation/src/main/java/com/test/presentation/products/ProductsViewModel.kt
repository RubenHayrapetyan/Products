package com.test.presentation.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.usecase.GetProductsFromDb
import com.test.domain.usecase.RemoveProduct
import com.test.domain.usecase.UpdateProductAmount
import com.test.presentation.products.ProductsContract.ProductsEvent.OnRemoveProductEvent
import com.test.presentation.products.ProductsContract.ProductsEvent.OnSearchEvent
import com.test.presentation.products.ProductsContract.ProductsEvent.OnUpdateProductAmountEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
  private val getProductsFromDb: GetProductsFromDb,
  private val removeProduct: RemoveProduct,
  private val updateProductAmount: UpdateProductAmount,
) : ViewModel() {

  init {
    getProducts()
  }

  var productsState by mutableStateOf(ProductsContract.ProductsState())
    private set

  fun onProductsEvent(event: ProductsContract.ProductsEvent) {
    when (event) {
      is OnSearchEvent -> {
        getProducts(query = event.query)
      }

      is OnRemoveProductEvent -> {
        removeProductById(event.productId)
      }

      is OnUpdateProductAmountEvent -> {
        updateProductAmountById(event.productId, event.newAmount)
      }
    }
  }

  private fun getProducts(query: String = "") {
    viewModelScope.launch {
      getProductsFromDb(searchQuery = query).collectLatest { products ->
        productsState = productsState.copy(products = products, searchQuery = query)
      }
    }
  }

  private fun removeProductById(productId: Long) {
    viewModelScope.launch {
      removeProduct(productId = productId)
      getProducts(productsState.searchQuery)
    }
  }

  private fun updateProductAmountById(productId: Long, newAmount: Int) {
    viewModelScope.launch {
      updateProductAmount(productId = productId, newAmount = newAmount)
      getProducts(productsState.searchQuery)
    }
  }
}