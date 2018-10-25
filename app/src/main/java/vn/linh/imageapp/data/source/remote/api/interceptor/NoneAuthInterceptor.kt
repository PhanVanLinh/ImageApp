package vn.linh.imageapp.data.source.remote.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import vn.linh.imageapp.data.AccessTokenWrapper
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class NoneAuthInterceptor @Inject constructor(private val accessTokenWrapper: AccessTokenWrapper) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
        val accessToken = accessTokenWrapper.accessToken
        requestBuilder
                .header("authorization", "bearer ${accessToken?.token}")
                .header("cache-control", "no-cache")
        requestBuilder.header("cache-control", "no-cache")
        return chain.proceed(requestBuilder.build())
    }
}