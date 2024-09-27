package com.test.data.local

import androidx.room.TypeConverter

class TagsTypeConverter {
  private val separator = ","

  @TypeConverter
  fun fromTagsList(tags: List<String>): String {
    return tags.joinToString(separator = separator)
  }

  @TypeConverter
  fun toTagsList(data: String): List<String> {
    return data.replace("[\\[\\]\"]".toRegex(), "")
      .split(separator)
      .map { it.trim() }
      .filter { it.isNotEmpty() }
  }
}
