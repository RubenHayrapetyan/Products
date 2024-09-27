package com.test.data.repository

import com.test.data.local.ProductsDao
import com.test.data.mapper.toProduct
import com.test.data.model.ProductEntity
import com.test.domain.model.Product
import com.test.domain.repository.ProductsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(private val productsDao: ProductsDao): ProductsRepo {

  override fun getAllProductsFromDb(): Flow<List<Product>> {
    val productsFlow: Flow<List<ProductEntity>> = productsDao.getAllProducts()
    val productsFlowMapped: Flow<List<Product>> = productsFlow.map { list ->
      list.map { productEntity ->
        productEntity.toProduct()
      }
    }
    return productsFlowMapped
  }

  override fun getSearchedProductsFromDb(query: String): Flow<List<Product>> {
    val productsFlow: Flow<List<ProductEntity>> = productsDao.getSearchedProducts(query = query)
    val productsFlowMapped: Flow<List<Product>> = productsFlow.map { list ->
      list.map { productEntity ->
        productEntity.toProduct()
      }
    }
    return productsFlowMapped
  }

  override suspend fun removeProduct(productId: Long) {
    productsDao.removeProduct(productId = productId)
  }

  override suspend fun updateProductAmount(productId: Long, newAmount: Int) {
    productsDao.updateProductAmount(productId = productId, newAmount = newAmount)
  }
}