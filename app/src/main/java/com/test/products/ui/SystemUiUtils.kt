package com.test.products.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.test.products.R

@Composable
fun SetColorToStatusBar() {
  val systemUiController = rememberSystemUiController()
  val blueColor = colorResource(R.color.status_bar)

  systemUiController.setStatusBarColor(
    color = blueColor,
    darkIcons = false
  )
}

@Composable
fun SetColorToNavigationBar() {
  val systemUiController = rememberSystemUiController()
  val blueColor = colorResource(R.color.status_bar)

  systemUiController.setNavigationBarColor(
    color = blueColor,
    darkIcons = false
  )
}