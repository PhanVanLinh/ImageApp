package vn.linh.imageapp.data.source.local.api

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject
import kotlin.reflect.KClass

class SharedPrefApi @Inject constructor(context: Context, private val gson: Gson) {

    companion object {
        const val ACCESS_TOKEN = "ACCESS_TOKEN"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            "image app",
            Context.MODE_PRIVATE)


    fun <T : Any> get(key: String, type: KClass<T>): T {
        return when (type) {
            String::class -> sharedPreferences.getString(key, "") as T
            Boolean::class -> sharedPreferences.getBoolean(key, false) as T
            Float::class -> sharedPreferences.getFloat(key, 0f) as T
            Int::class -> sharedPreferences.getInt(key, 0) as T
            Long::class -> sharedPreferences.getLong(key, 0) as T
            else -> gson.fromJson(sharedPreferences.getString(key, ""), type.java)
        }
    }

    fun <T> put(key: String, data: T) {
        val editor = sharedPreferences.edit()
        when (data) {
            is String -> editor.putString(key, data as String)
            is Boolean -> editor.putBoolean(key, data as Boolean)
            is Float -> editor.putFloat(key, data as Float)
            is Int -> editor.putInt(key, data as Int)
            is Long -> editor.putLong(key, data as Long)
            else -> editor.putString(key, gson.toJson(data))
        }
        editor.apply()
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}