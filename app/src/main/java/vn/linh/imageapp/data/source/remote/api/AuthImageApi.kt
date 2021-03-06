package vn.linh.imageapp.data.source.remote.api

import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import vn.linh.imageapp.data.model.Image
import vn.linh.imageapp.data.source.remote.api.request.LoginRequest
import vn.linh.imageapp.data.source.remote.api.response.GetImageResponse
import vn.linh.imageapp.data.source.remote.api.response.LoginResponse

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

interface AuthImageApi {

    @POST("/login")
    fun login(@Body userName: RequestBody): Single<LoginResponse>

    @GET("/image")
    fun getImage(): Single<GetImageResponse>
}
