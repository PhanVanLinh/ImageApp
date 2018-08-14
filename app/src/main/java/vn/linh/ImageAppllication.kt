package vn.linh

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import vn.linh.imageapp.di.DaggerAppComponent

class ImageAppllication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}
