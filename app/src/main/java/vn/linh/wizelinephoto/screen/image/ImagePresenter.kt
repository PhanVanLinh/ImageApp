package vn.linh.wizelinephoto.screen.image

import io.reactivex.schedulers.Schedulers
import vn.linh.wizelinephoto.data.source.UserRepository
import javax.inject.Inject

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class ImagePresenter @Inject constructor(val userRepository: UserRepository) : ImageContract.Presenter {

    override fun login(userName: String) {
        userRepository.login(userName).subscribeOn(Schedulers.io()).subscribe({},{})
    }
}