package vn.linh.wizelinephoto.data.source

import vn.linh.wizelinephoto.data.source.local.ImageLocalDatasource
import vn.linh.wizelinephoto.data.source.remote.ImageRemoteDataSource

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class ImageRepository(val localDatasource: ImageLocalDatasource,
                      val remoteDataSource: ImageRemoteDataSource) {



}
