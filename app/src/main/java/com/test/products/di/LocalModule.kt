package com.test.products.di

import android.content.Context
import androidx.room.Room
import com.test.data.local.ProductsDao
import com.test.data.local.ProductsDatabase
import com.test.products.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

  @Provides
  @Singleton
  fun provideDatabase(@ApplicationContext context: Context): ProductsDatabase =
    Room.databaseBuilder(
      context,
      ProductsDatabase::class.java,
      AppConstants.DB_NAME
    )
      .createFromAsset(AppConstants.DB_NAME)
      .build()

  @Provides
  fun provideProductsDao(db: ProductsDatabase): ProductsDao = db.productsDao
}