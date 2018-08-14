package vn.linh.wizelinephoto.data.source.remote

import io.reactivex.Single
import vn.linh.wizelinephoto.data.source.remote.api.PhotoApi
import vn.linh.wizelinephoto.data.source.remote.api.request.LoginRequest
import vn.linh.wizelinephoto.data.source.remote.api.response.LoginResponse
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class UserRemoteDataSource @Inject constructor(val photoApi: PhotoApi) {

    fun login(userName: String): Single<LoginResponse> {
        return photoApi.login(LoginRequest(userName))
    }
}