package com.test.products.screens.products.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.test.products.R
import com.test.products.ui.theme.DimensDp
import com.test.products.ui.theme.DimensSp

@Composable
fun DeleteDialog(
  modifier: Modifier = Modifier,
  onNo: () -> Unit,
  onYes: () -> Unit
) {

  AlertDialog(
    modifier = modifier
      .clip(RoundedCornerShape(DimensDp.deleteDialogRadius))
      .padding(DimensDp.paddingBig),
    containerColor = colorResource(R.color.delete_dialog_background),
    onDismissRequest = { onNo() },
    title = {
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Icon(
          imageVector = Icons.Default.Warning,
          contentDescription = null,
          modifier = Modifier.size(DimensDp.iconsSize),
          tint = colorResource(R.color.dialog_warning)
        )
        Text(
          text = stringResource(R.string.udalenie_tovara),
          style = TextStyle(fontSize = DimensSp.textVeryBig, color = colorResource(R.color.black)),
          modifier = Modifier.padding(top = DimensDp.paddingMedium)
        )
      }
    },
    text = {
      Text(
        fontSize = DimensSp.textSmall,
        text = stringResource(R.string.remove_dialog_text)
      )
    },
    confirmButton = {
      TextButton(onClick = { onYes() }) {
        Text(
          text = stringResource(R.string.da),
          color = colorResource(R.color.dialog_button)
        )
      }
    },
    dismissButton = {
      TextButton(onClick = { onNo() }) {
        Text(
          text = stringResource(R.string.net),
          color = colorResource(R.color.dialog_button)
        )
      }
    },
  )
}

@Preview
@Composable
fun DeleteDialogPreview() {
  DeleteDialog(onNo = {}, onYes = {})
}