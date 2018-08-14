package vn.linh.imageapp.data.source

import vn.linh.imageapp.data.source.local.ImageLocalDatasource
import vn.linh.imageapp.data.source.remote.ImageRemoteDataSource

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class ImageRepository(val localDatasource: ImageLocalDatasource,
                      val remoteDataSource: ImageRemoteDataSource) {



}
