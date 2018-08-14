package vn.linh.imageapp.data.source.remote

import io.reactivex.Single
import vn.linh.imageapp.data.model.Image
import vn.linh.imageapp.data.source.remote.api.AuthImageApi
import vn.linh.imageapp.data.source.remote.api.response.GetImageResponse
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */
class ImageRemoteDataSource @Inject constructor(val authImageApi: AuthImageApi) {

    fun getImage(): Single<GetImageResponse> {
        return authImageApi.getImage()
    }
}