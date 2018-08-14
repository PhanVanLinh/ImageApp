package vn.linh.wizelinephoto.data.source.remote.api.response

import com.google.gson.annotations.Expose

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
        val expires_in: Long
)
