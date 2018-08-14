package vn.linh.imageapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.linh.imageapp.di.scope.ActivityScope
import vn.linh.imageapp.screen.image.ImageActivity
import vn.linh.imageapp.screen.image.ImageModule
import vn.linh.imageapp.screen.imagedetail.ImageDetailActivity
import vn.linh.imageapp.screen.imagedetail.ImageDetailModule

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ImageModule::class])
    @ActivityScope
    abstract fun bindImageActivty(): ImageActivity


    @ContributesAndroidInjector(modules = [ImageDetailModule::class])
    @ActivityScope
    abstract fun bindImageDetailActivty(): ImageDetailActivity
}