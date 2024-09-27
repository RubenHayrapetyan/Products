package com.test.products.screens.products.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.test.domain.model.Product
import com.test.products.R
import com.test.products.ui.theme.DimensDp
import com.test.products.ui.theme.DimensSp
import com.test.products.util.toDDmmYYYYTimeString

@Composable
fun ProductItem(
  product: Product,
  onProductRemove: (Long) -> Unit,
  onAmountChange: (Long, Int) -> Unit,
  modifier: Modifier = Modifier
) {
  Card(
    elevation = CardDefaults.cardElevation(DimensDp.productItemCardElevation),
    shape = RoundedCornerShape(DimensDp.productItemRadius),
    modifier = modifier
      .fillMaxWidth()
      .padding(DimensDp.paddingMedium)
  ) {
    Column(
      modifier = Modifier
        .background(colorResource(R.color.white))
        .padding(DimensDp.paddingSmall)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          modifier = Modifier.weight(1f),
          text = product.name,
          style = TextStyle(
            fontSize = DimensSp.textBig,
            color = colorResource(R.color.black),
            fontWeight = FontWeight(500)
          )
        )

        IconButton(
          modifier = Modifier.size(DimensDp.iconsSize),
          onClick = { onAmountChange(product.id, product.amount) }
        ) {
          Icon(
            Icons.Default.Edit, contentDescription = "Edit",
            tint = colorResource(R.color.dialog_edit_icon)
          )
        }

        Spacer(modifier = Modifier.width(DimensDp.paddingBig))

        IconButton(
          modifier = Modifier.size(DimensDp.iconsSize),
          onClick = { onProductRemove(product.id) }
        ) {
          Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
        }

        Spacer(modifier = Modifier.width(DimensDp.paddingSmall))
      }

      Spacer(modifier = Modifier.height(DimensDp.paddingBig))

      val tags = product.tags
      if (tags.isNotEmpty()) {
        TagList(tags = tags)
        Spacer(modifier = Modifier.height(DimensDp.paddingMedium))
      }

      Row(
        modifier = Modifier.fillMaxWidth(),
      ) {
        Text(
          modifier = Modifier.weight(1f),
          text = stringResource(R.string.na_sklade),
          style = TextStyle(
            fontSize = DimensSp.textMedium,
            color = colorResource(R.color.black),
            fontWeight = FontWeight(500)
          )
        )
        Text(
          modifier = Modifier.weight(1f),
          text = stringResource(R.string.data_dobavlenia),
          style = TextStyle(
            fontSize = DimensSp.textMedium,
            color = colorResource(R.color.black),
            fontWeight = FontWeight(500)
          )

        )
      }

      Row(
        modifier = Modifier.fillMaxWidth(),
      ) {
        val amount = product.amount
        val text = if (amount == 0) {
          stringResource(R.string.net_v_nalichii)
        } else {
          "$amount"
        }

        Text(
          modifier = Modifier.weight(1f),
          text = text,
          fontSize = DimensSp.textMedium
        )
        Text(
          modifier = Modifier.weight(1f),
          text = product.time.toDDmmYYYYTimeString(),
          fontSize = DimensSp.textMedium
        )
      }
    }
  }
}

@Preview
@Composable
fun ProductItemPreview() {
  ProductItem(
    product = Product(
      id = 1,
      name = "Product 1",
      amount = 10,
      tags = listOf("Tag 1", "Tag 2"),
      time = System.currentTimeMillis()
    ),
    onProductRemove = {},
    onAmountChange = { _, _ -> }
  )
}