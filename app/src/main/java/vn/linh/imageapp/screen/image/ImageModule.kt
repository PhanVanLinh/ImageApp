package vn.linh.imageapp.screen.image

import dagger.Binds
import dagger.Module

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

@Module
abstract class ImageModule {

    @Binds
    abstract fun bindImagePresenter(imagePresenter: ImagePresenter): ImageContract.Presenter

    @Binds
    abstract fun bindImageView(view: ImageActivity): ImageContract.View
}