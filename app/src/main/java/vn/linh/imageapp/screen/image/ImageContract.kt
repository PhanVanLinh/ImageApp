package vn.linh.imageapp.screen.image

import vn.linh.imageapp.data.model.Image

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

interface ImageContract {

    interface View {

        fun onGetImageSuccess(images: List<Image>)

        fun onGetImageFailed(exception: Throwable)

        fun showLoading()

        fun hideLoading()
    }

    interface Presenter {

        fun getImage()
    }
}