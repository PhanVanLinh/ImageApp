package vn.linh.wizelinephoto.data.source.remote.api

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import vn.linh.wizelinephoto.data.model.Image
import vn.linh.wizelinephoto.data.source.remote.api.request.LoginRequest
import vn.linh.wizelinephoto.data.source.remote.api.response.LoginResponse

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

interface PhotoApi {

    @POST("/login")
    fun login(@Body userName: LoginRequest): Single<LoginResponse>

    @GET("/image")
    fun getImage(): Single<List<Image>>
}
