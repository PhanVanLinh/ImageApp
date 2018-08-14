package vn.linh.imageapp.screen.splash

interface SplashContract {

    interface View {
        fun onLoginSuccess()

        fun onLoginFailed()

        fun showLoading()

        fun hideLoading()
    }

    interface Presenter {

        fun login(userName: String)
    }
}