package com.test.products.screens.products.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.test.products.R

@Composable
fun Search(
  onQueryChange: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  var searchQuery by rememberSaveable { mutableStateOf("") }
  val focusManager = LocalFocusManager.current
  val keyboardController = LocalSoftwareKeyboardController.current

  val focusedIndicator = colorResource(R.color.products_search_focused_indicator)
  val unfocusedIndicator = colorResource(R.color.products_search_unfocused_indicator)
  val focusedContainer = colorResource(R.color.products_search_focused_container)
  val unfocusedContainer = colorResource(R.color.products_search_unfocused_container)
  val focusedLabel = colorResource(R.color.products_search_focused_label)

  OutlinedTextField(
    modifier = modifier,
    value = searchQuery,
    onValueChange = {
      searchQuery = it
      onQueryChange(searchQuery)
    },
    label = {
      Text(
        text = stringResource(id = R.string.poisk_tovarov),
        color = focusedLabel
      )
    },
    singleLine = true,
    colors = TextFieldDefaults.colors(
      focusedIndicatorColor = focusedIndicator,
      unfocusedIndicatorColor = unfocusedIndicator,
      focusedContainerColor = focusedContainer,
      unfocusedContainerColor = unfocusedContainer,
      focusedLabelColor = focusedLabel
    ),
    keyboardOptions = KeyboardOptions.Default.copy(
      imeAction = ImeAction.Search
    ),
    keyboardActions = KeyboardActions(
      onSearch = {
        onQueryChange(searchQuery)
        keyboardController?.hide()
        focusManager.clearFocus()
      }
    ),
    leadingIcon = {
      Icon(
        imageVector = Icons.Filled.Search,
        contentDescription = "Search Icon"
      )
    },
    trailingIcon = {
      if (searchQuery.isNotEmpty()) {
        IconButton(onClick = {
          searchQuery = ""
          onQueryChange(searchQuery)
          keyboardController?.hide()
          focusManager.clearFocus()
        }) {
          Icon(
            imageVector = Icons.Filled.Clear,
            contentDescription = "Clear Icon"
          )
        }
      }
    }
  )
}

@Preview
@Composable
fun SearchPreview() {
  Search(onQueryChange = {})
}