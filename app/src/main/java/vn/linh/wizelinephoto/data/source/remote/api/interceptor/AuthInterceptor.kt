package vn.linh.wizelinephoto.data.source.remote.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class AuthInterceptor  : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
//                .header("'authorization", "bearer your-token")
//                .header("cache-control", "no-cache")
//                .method(original.method(), original.body())
                .build()

        return chain.proceed(request)
    }

}