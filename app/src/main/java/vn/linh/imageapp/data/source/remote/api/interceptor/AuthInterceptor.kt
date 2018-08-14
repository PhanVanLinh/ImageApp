package vn.linh.imageapp.data.source.remote.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import vn.linh.imageapp.data.model.AccessToken
import vn.linh.imageapp.data.source.UserRepository
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class AuthInterceptor @Inject constructor(val accessToken: AccessToken?) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
        if (accessToken != null && !accessToken.isExpired()) {
            requestBuilder
                    .header("authorization", "bearer ${accessToken.token}")
                    .header("cache-control", "no-cache")
        }
        requestBuilder.header("cache-control", "no-cache")
        return chain.proceed(requestBuilder.build())
    }
}