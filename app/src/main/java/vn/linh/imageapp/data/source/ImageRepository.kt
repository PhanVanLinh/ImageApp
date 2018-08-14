package vn.linh.imageapp.data.source

import io.reactivex.Single
import vn.linh.imageapp.data.model.Image
import vn.linh.imageapp.data.source.local.ImageLocalDataSource
import vn.linh.imageapp.data.source.remote.ImageRemoteDataSource

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class ImageRepository(private val localDataSource: ImageLocalDataSource,
                      private val remoteDataSource: ImageRemoteDataSource) {

    fun getImage(): Single<List<Image>> {
        return remoteDataSource.getImage().map {
            it.images
        }
    }
}
