package com.test.products.screens.products.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.test.products.R
import com.test.products.ui.theme.DimensDp
import com.test.products.ui.theme.DimensSp

@Composable
fun AmountUpdateDialog(
  modifier: Modifier = Modifier,
  currentQuantity: Int,
  onDismiss: () -> Unit,
  onAccept: (Int) -> Unit
) {
  var quantity by remember { mutableIntStateOf(currentQuantity) }

  AlertDialog(
    modifier = modifier
      .clip(RoundedCornerShape(DimensDp.amountDialogRadius))
      .padding(DimensDp.paddingBig),
    containerColor = colorResource(R.color.amount_update_dialog_background),
    onDismissRequest = { onDismiss() },
    title = {
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Icon(
          imageVector = Icons.Default.Settings,
          contentDescription = null,
          modifier = Modifier.size(DimensDp.iconsSize)
        )
        Text(
          text = stringResource(R.string.kolichestvo_tovara),
          style = TextStyle(fontSize = DimensSp.textVeryBig, color = colorResource(R.color.black)),
          modifier = Modifier.padding(top = DimensDp.paddingMedium)
        )
      }
    },
    text = {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Row(
          horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = DimensDp.paddingBig)
        ) {
          IconButton(
            onClick = { if (quantity > 0) quantity-- },
          ) {
            Image(
              modifier = Modifier.size(DimensDp.iconsSize),
              painter = painterResource(R.drawable.minus_icon),
              contentDescription = "Decrease"
            )
          }

          Text(
            text = "$quantity",
            style = TextStyle(fontSize = DimensSp.amountDialogText, fontWeight = FontWeight(500)),
            modifier = Modifier.padding(horizontal = DimensDp.paddingVeryBig)
          )

          IconButton(onClick = { quantity++ }) {
            Image(
              modifier = Modifier.size(DimensDp.iconsSize),
              painter = painterResource(R.drawable.plus_icon),
              contentDescription = "Decrease"
            )
          }
        }
      }
    },
    confirmButton = {
      TextButton(onClick = { onAccept(quantity) }) {
        Text(
          text = stringResource(R.string.prinyat),
          color = colorResource(R.color.dialog_button)
        )
      }
    },
    dismissButton = {
      TextButton(onClick = { onDismiss() }) {
        Text(
          text = stringResource(R.string.otmena),
          color = colorResource(R.color.dialog_button)
        )
      }
    },
  )
}

@Preview
@Composable
fun AmountUpdateDialogPreview() {
  AmountUpdateDialog(
    currentQuantity = 10,
    onDismiss = {},
    onAccept = {}
  )
}