package vn.linh.imageapp.data.source.local

import vn.linh.imageapp.data.model.AccessToken
import vn.linh.imageapp.data.source.local.api.SharedPrefApi
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */
class UserLocalDataSource @Inject constructor(private val sharedPrefApi: SharedPrefApi) {

    fun saveAccessToken(accessToken: AccessToken) {
        sharedPrefApi.put(SharedPrefApi.ACCESS_TOKEN, accessToken)
    }

    fun getAccessToken(): AccessToken? {
        return sharedPrefApi.get(SharedPrefApi.ACCESS_TOKEN, AccessToken::class)
    }
}