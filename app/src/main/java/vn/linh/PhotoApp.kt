package vn.linh

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import vn.linh.wizelinephoto.di.DaggerAppComponent

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

class PhotoApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}
