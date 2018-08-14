package vn.linh.wizelinephoto.data.source.remote.api.request

import com.google.gson.annotations.SerializedName

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */
data class LoginRequest(
        @SerializedName("username")
        val userName: String) {

}