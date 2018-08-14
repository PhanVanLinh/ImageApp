package vn.linh.imageapp.di

import dagger.Module
import dagger.Provides
import vn.linh.imageapp.data.source.ImageRepository
import vn.linh.imageapp.data.source.UserRepository
import vn.linh.imageapp.data.source.local.ImageLocalDataSource
import vn.linh.imageapp.data.source.local.UserLocalDataSource
import vn.linh.imageapp.data.source.remote.ImageRemoteDataSource
import vn.linh.imageapp.data.source.remote.UserRemoteDataSource
import javax.inject.Singleton

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providePhotoRepository(localDataSource: ImageLocalDataSource, remoteDataSource: ImageRemoteDataSource): ImageRepository {
        return ImageRepository(localDataSource, remoteDataSource)
    }

    @Singleton
    @Provides
    fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource, userLocalDataSource: UserLocalDataSource): UserRepository {
        return UserRepository(userRemoteDataSource, userLocalDataSource)
    }
}