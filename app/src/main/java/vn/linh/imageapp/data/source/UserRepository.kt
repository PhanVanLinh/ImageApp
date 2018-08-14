package vn.linh.imageapp.data.source

import io.reactivex.Completable
import vn.linh.imageapp.data.model.AccessToken
import vn.linh.imageapp.data.source.local.UserLocalDataSource
import vn.linh.imageapp.data.source.remote.UserRemoteDataSource

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */
class UserRepository(private val userRemoteDataSource: UserRemoteDataSource, private val userLocalDataSource: UserLocalDataSource) {

    fun login(userName: String): Completable {
        if (isAccessTokenNotExpired()) {
            return Completable.complete()
        }
        return userRemoteDataSource.login(userName).flatMapCompletable { response ->
            Completable.fromAction { userLocalDataSource.saveAccessToken(AccessToken(response.token, response.getExpiresTime())) }
        }
    }

    private fun isAccessTokenNotExpired(): Boolean {
        val accessToken = userLocalDataSource.getAccessToken()
        return accessToken != null && !accessToken.isExpired()
    }
}