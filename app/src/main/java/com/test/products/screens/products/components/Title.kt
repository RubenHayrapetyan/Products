package com.test.products.screens.products.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.test.products.R
import com.test.products.ui.theme.DimensDp
import com.test.products.ui.theme.DimensSp

@Composable
fun Title(modifier: Modifier = Modifier) {
  Box(
    modifier = modifier
      .background(color = colorResource(R.color.title_background))
      .padding(DimensDp.paddingVeryBig),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = stringResource(R.string.spisok_tovarov),
      style = TextStyle(fontSize = DimensSp.textBig)
    )
  }
}

@Preview
@Composable
fun TitlePreview() {
  Title()
}