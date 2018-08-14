package vn.linh.imageapp.screen

import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

abstract open class BaseActivity : DaggerAppCompatActivity() {

    abstract fun initView()

    open fun getDataFromIntent() {

    }

    open fun updateView() {

    }
}