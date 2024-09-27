package com.test.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.test.data.model.ProductEntity
import com.test.data.util.DataConstants
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {
  @Upsert
  suspend fun upsertAllProducts(products: List<ProductEntity>)

  @Query("DELETE FROM ${DataConstants.PRODUCTS_TABLE_NAME} WHERE id = :productId")
  suspend fun removeProduct(productId: Long)

  @Query("UPDATE ${DataConstants.PRODUCTS_TABLE_NAME} SET amount = :newAmount WHERE id = :productId")
  suspend fun updateProductAmount(productId: Long, newAmount: Int)

  @Query("SELECT * FROM ${DataConstants.PRODUCTS_TABLE_NAME}")
  fun getAllProducts(): Flow<List<ProductEntity>>

  @Query("SELECT * FROM ${DataConstants.PRODUCTS_TABLE_NAME} WHERE name LIKE '%' || :query || '%'")
  fun getSearchedProducts(query: String): Flow<List<ProductEntity>>
}