package vn.linh.imageapp.utils.common

import android.text.TextUtils
import java.text.SimpleDateFormat
import java.util.*

fun Long.toTimeString(format: String, locale: Locale = Locale.getDefault()): String? {
    if (TextUtils.isEmpty(format)) return null
    return SimpleDateFormat(format, locale).format(Date(this))
}
