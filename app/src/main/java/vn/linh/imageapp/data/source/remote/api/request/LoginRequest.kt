package vn.linh.imageapp.data.source.remote.api.request

import okhttp3.RequestBody
import org.json.JSONObject

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */
data class LoginRequest(
        val userName: String) {

    fun get(): RequestBody {
        val jsonParams = mutableMapOf<String, Any>()
        jsonParams["username"] = userName
        return RequestBody.create(okhttp3.MediaType
                .parse("application/json; charset=utf-8"),
                (JSONObject(jsonParams)).toString())
    }
}