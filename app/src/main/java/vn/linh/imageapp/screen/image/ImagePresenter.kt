package vn.linh.imageapp.screen.image

import io.reactivex.schedulers.Schedulers
import vn.linh.imageapp.data.source.ImageRepository
import vn.linh.imageapp.data.source.UserRepository
import vn.linh.imageapp.rx.SchedulerProvider
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class ImagePresenter @Inject constructor(private val userRepository: UserRepository,
                                         private val imageRepository: ImageRepository,
                                         private val schedulerProvider: SchedulerProvider) : ImageContract.Presenter {
    @Inject
    lateinit var view: ImageContract.View

    override fun getImage() {
        imageRepository.getImage()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui()).subscribe({
                    view.onGetImageSuccess(it)
                }, {
                    view.onGetImageFailed(it)
                })
    }
}