package com.test.products.screens.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.test.presentation.products.ProductsContract
import com.test.products.R
import com.test.products.screens.products.components.AmountUpdateDialog
import com.test.products.screens.products.components.DeleteDialog
import com.test.products.screens.products.components.ProductList
import com.test.products.screens.products.components.Title
import com.test.products.ui.SetColorToNavigationBar
import com.test.products.ui.SetColorToStatusBar

@Composable
fun ProductsScreen(
  state: ProductsContract.ProductsState,
  onEvent: (ProductsContract.ProductsEvent) -> Unit,
) {

  var isAmountUpdateDialogShowing by remember { mutableStateOf(false) }
  var isDeleteDialogShowing by remember { mutableStateOf(false) }
  var selectedProductId by remember { mutableStateOf<Long?>(null) }
  var newAmount by remember { mutableIntStateOf(0) }

  SetColorToStatusBar()
  SetColorToNavigationBar()

  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.products_list_background))
        .padding(innerPadding)
    ) {

      Title(modifier = Modifier.fillMaxWidth())

      ProductList(
        modifier = Modifier.fillMaxWidth(),
        products = state.products ?: emptyList(),
        onQueryChange = { query ->
          onEvent(ProductsContract.ProductsEvent.OnSearchEvent(query))
        },
        onProductRemove = { productId ->
          selectedProductId = productId
          isDeleteDialogShowing = true
        },
        onAmountChange = { productId, amount ->
          selectedProductId = productId
          newAmount = amount
          isAmountUpdateDialogShowing = true
        }
      )

      if (isAmountUpdateDialogShowing) {
        AmountUpdateDialog(
          currentQuantity = newAmount,
          onDismiss = {
            isAmountUpdateDialogShowing = false
          },
          onAccept = { updatedAmount ->
            isAmountUpdateDialogShowing = false
            selectedProductId?.let { id ->
              onEvent(ProductsContract.ProductsEvent.OnUpdateProductAmountEvent(id, updatedAmount))
            }
          }
        )
      }

      if (isDeleteDialogShowing) {
        DeleteDialog(
          onNo = {
            isDeleteDialogShowing = false
          },
          onYes = {
            isDeleteDialogShowing = false
            selectedProductId?.let { id ->
              onEvent(ProductsContract.ProductsEvent.OnRemoveProductEvent(id))
            }
          })
      }
    }
  }
}