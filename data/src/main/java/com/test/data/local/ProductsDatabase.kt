package com.test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.test.data.model.ProductEntity

@Database(
  entities = [ProductEntity::class],
  version = 1
)
@TypeConverters(TagsTypeConverter::class)
abstract class ProductsDatabase : RoomDatabase() {

  abstract val productsDao: ProductsDao
}
