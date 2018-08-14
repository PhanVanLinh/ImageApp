package vn.linh.wizelinephoto.di

import dagger.Module
import dagger.Provides
import vn.linh.wizelinephoto.data.source.ImageRepository
import vn.linh.wizelinephoto.data.source.UserRepository
import vn.linh.wizelinephoto.data.source.local.ImageLocalDatasource
import vn.linh.wizelinephoto.data.source.local.UserLocalDataSource
import vn.linh.wizelinephoto.data.source.remote.ImageRemoteDataSource
import vn.linh.wizelinephoto.data.source.remote.UserRemoteDataSource
import javax.inject.Singleton

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providePhotoRepository(localDataSource: ImageLocalDatasource, remoteDataSource: ImageRemoteDataSource): ImageRepository {
        return ImageRepository(localDataSource, remoteDataSource)
    }

    @Singleton
    @Provides
    fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource, userLocalDataSource: UserLocalDataSource): UserRepository {
        return UserRepository(userRemoteDataSource, userLocalDataSource)
    }
}