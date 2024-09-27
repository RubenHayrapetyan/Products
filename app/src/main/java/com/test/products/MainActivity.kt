package com.test.products

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.test.presentation.products.ProductsViewModel
import com.test.products.screens.products.ProductsScreen
import com.test.products.ui.theme.ProductsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      ProductsTheme {
        val viewModel = hiltViewModel<ProductsViewModel>()
        ProductsScreen(
          state = viewModel.productsState,
          onEvent = viewModel::onProductsEvent
        )
      }
    }
  }
}
