package com.test.products.di

import com.test.data.repository.ProductsRepoImpl
import com.test.domain.repository.ProductsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class RepositoryModule {
  @Binds
  abstract fun bindProductsRepository(repository: ProductsRepoImpl): ProductsRepo
}