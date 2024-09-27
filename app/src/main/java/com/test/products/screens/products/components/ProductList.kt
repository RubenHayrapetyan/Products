package com.test.products.screens.products.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.domain.model.Product
import com.test.products.ui.theme.DimensDp

@Composable
fun ProductList(
  modifier: Modifier,
  products: List<Product>,
  onQueryChange: (String) -> Unit,
  onProductRemove: (Long) -> Unit,
  onAmountChange: (Long, Int) -> Unit,
) {
  LazyColumn(modifier = modifier) {

    item {
      Search(
        modifier = Modifier
          .fillMaxWidth()
          .padding(DimensDp.paddingSmall),
        onQueryChange = onQueryChange
      )
    }

    items(products, key = { it.id }) {
      ProductItem(
        product = it,
        onProductRemove = onProductRemove,
        onAmountChange = onAmountChange
      )
    }
  }
}

@Preview
@Composable
fun ProductListPreview() {
  ProductList(
    modifier = Modifier,
    products = listOf(
      Product(
        id = 1,
        name = "iPhone 13",
        time = 1633046400000,
        tags = listOf("Телефон", "Новый", "Распродажаааааааааааааааааааа"),
        amount = 15
      ),
      Product(
        id = 2,
        name = "Samsung Galaxy S21",
        time = 1633132800000,
        tags = listOf("Телефон", "Хит"),
        amount = 30
      ),
      Product(
        id = 3,
        name = "PlayStation 5",
        time = 1633219200000,
        tags = listOf("Игровая приставка", "Акция", "Распродажа"),
        amount = 7
      )
    ),
    onProductRemove = {},
    onQueryChange = {},
    onAmountChange = { _, _ -> }
  )
}