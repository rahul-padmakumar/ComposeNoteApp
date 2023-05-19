package com.example.composenoteapp.utils

import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String{
    val date = Date(time)
    val format = SimpleDateFormat("EEE, dd MMM hh:mm aaa", Locale.getDefault())
    return format.format(date)
}