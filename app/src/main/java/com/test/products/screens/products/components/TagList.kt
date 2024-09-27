package com.test.products.screens.products.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.flowlayout.FlowRow
import com.test.products.ui.theme.DimensDp

@Composable
fun TagList(tags: List<String>, modifier: Modifier = Modifier) {
  FlowRow(
    modifier = modifier,
    mainAxisSpacing = DimensDp.tagListMainAndCrossAxis,
    crossAxisSpacing = DimensDp.tagListMainAndCrossAxis
  ) {
    tags.forEach { tag ->
      TagItem(text = tag)
    }
  }
}

@Preview
@Composable
fun TagListPreview() {
  TagList(tags = listOf("Tag 1", "Tag 2", "Tag 3"))
}