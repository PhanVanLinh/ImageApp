package vn.linh.imageapp.screen.splash

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import vn.linh.imageapp.BuildConfig
import vn.linh.imageapp.R
import vn.linh.imageapp.navigation.Navigator
import vn.linh.imageapp.screen.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var splashPresenter: SplashPresenter

    @Inject
    lateinit var navigator: Navigator

    lateinit var pbLoading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initView()
        splashPresenter.login(BuildConfig.DEFAULT_USER)
    }

    override fun initView() {
        pbLoading = findViewById(R.id.progress_bar_loading)
    }

    override fun showLoading() {
        pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = View.INVISIBLE
    }

    override fun onLoginSuccess() {
        navigator.startImageScreen(this)
        finish()
    }

    override fun onLoginFailed() {
        // do nothing
    }
}
