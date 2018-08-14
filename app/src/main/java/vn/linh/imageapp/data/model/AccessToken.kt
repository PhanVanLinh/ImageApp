package vn.linh.imageapp.data.model

import com.google.gson.annotations.Expose

data class AccessToken(
        @Expose
        val token: String,
        @Expose
        val expiredTime: Long) {

    fun isExpired() = expiredTime < System.currentTimeMillis()
}