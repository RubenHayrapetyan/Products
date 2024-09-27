package com.test.products.di

import com.test.core.util.IODispatcher
import com.test.core.util.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object DispatchersModule {

  @IODispatcher
  @Provides
  fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

  @MainDispatcher
  @Provides
  fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}