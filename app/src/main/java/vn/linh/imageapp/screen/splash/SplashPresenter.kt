package vn.linh.imageapp.screen.splash

import vn.linh.imageapp.data.source.UserRepository
import vn.linh.imageapp.rx.SchedulerProvider
import javax.inject.Inject

class SplashPresenter @Inject constructor(val userRepository: UserRepository, val schedulerProvider: SchedulerProvider) : SplashContract.Presenter {

    @Inject
    lateinit var view: SplashContract.View

    override fun login(userName: String) {
        userRepository.login(userName)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui()).subscribe({
                    view.onLoginSuccess()
                }, {
                    view.onLoginFailed()
                })
    }
}