package com.test.products.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toDDmmYYYYTimeString(): String {
  val format = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
  return format.format(Date(this))
}