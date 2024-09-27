package com.test.products.di

import com.test.domain.usecase.GetProductsFromDb
import com.test.domain.usecase.GetProductsFromDbImpl
import com.test.domain.usecase.RemoveProduct
import com.test.domain.usecase.RemoveProductImpl
import com.test.domain.usecase.UpdateProductAmount
import com.test.domain.usecase.UpdateProductAmountImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseModule {
  @Binds
  abstract fun bindGetProductsFromDb(useCase: GetProductsFromDbImpl): GetProductsFromDb

  @Binds
  abstract fun bindRemoveProduct(useCase: RemoveProductImpl): RemoveProduct

  @Binds
  abstract fun bindUpdateProductAmount(useCase: UpdateProductAmountImpl): UpdateProductAmount
}