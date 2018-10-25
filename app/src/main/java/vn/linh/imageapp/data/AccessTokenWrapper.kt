package vn.linh.imageapp.data

import vn.linh.imageapp.data.model.AccessToken
import vn.linh.imageapp.data.source.local.api.SharedPrefApi
import javax.inject.Inject

class AccessTokenWrapper @Inject constructor(private val sharedPrefApi: SharedPrefApi) {

    var accessToken: AccessToken? = null
        get() {
            if (field != null) {
                return field
            }
            accessToken = sharedPrefApi.get(SharedPrefApi.ACCESS_TOKEN, AccessToken::class)
            return field
        }
}