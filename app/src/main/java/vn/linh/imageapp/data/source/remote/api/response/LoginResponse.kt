package vn.linh.imageapp.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.concurrent.TimeUnit

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

//{"id":2,"username":"wizeline","token":"wize@123","displayName":"Wize Line","email":"test@example.com","expires_in":3600}
data class LoginResponse(
        @Expose
        val id: Int,
        @Expose
        val username: String,
        @Expose
        val token: String,
        @Expose
        val displayName: String,
        @Expose
        val email: String,
        @Expose
        @SerializedName("expires_in")
        val expiresIn: Long
) {

    fun getExpiresTime(): Long {
        return expiresIn * 1000 + System.currentTimeMillis()
    }
}
