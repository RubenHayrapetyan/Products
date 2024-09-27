package com.test.products.screens.products.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.test.products.R
import com.test.products.ui.theme.DimensDp
import com.test.products.ui.theme.DimensSp

@Composable
fun TagItem(text: String, modifier: Modifier = Modifier) {

  Box(
    modifier = modifier
      .border(
        BorderStroke(DimensDp.tagBorderRadius, colorResource(R.color.tag_corner)),
        shape = RoundedCornerShape(DimensDp.tagCornerRadius)
      )
      .clip(RoundedCornerShape(DimensDp.tagCornerRadius))
      .background(color = colorResource(R.color.white)),
  ) {
    Text(
      text = text,
      modifier = Modifier.padding(
        horizontal = DimensDp.tagHorizontalPadding,
        vertical = DimensDp.tagVerticalPadding
      ),
      color = colorResource(R.color.black),
      fontWeight = FontWeight(500),
      fontSize = DimensSp.textTagItem,
      overflow = TextOverflow.Ellipsis
    )
  }
}

@Preview
@Composable
fun TagItemPreview() {
  TagItem(text = "Tag Text")
}