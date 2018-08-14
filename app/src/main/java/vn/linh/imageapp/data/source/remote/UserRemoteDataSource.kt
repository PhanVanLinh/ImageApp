package vn.linh.imageapp.data.source.remote

import io.reactivex.Single
import vn.linh.imageapp.data.source.remote.api.AuthImageApi
import vn.linh.imageapp.data.source.remote.api.request.LoginRequest
import vn.linh.imageapp.data.source.remote.api.response.LoginResponse
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class UserRemoteDataSource @Inject constructor(private val authImageApi: AuthImageApi) {

    fun login(userName: String): Single<LoginResponse> {
        return authImageApi.login(LoginRequest(userName).get())
    }
}