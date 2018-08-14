package vn.linh.wizelinephoto.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.linh.wizelinephoto.di.scope.ActivityScope
import vn.linh.wizelinephoto.screen.image.ImageActivity
import vn.linh.wizelinephoto.screen.image.ImageModule
import vn.linh.wizelinephoto.screen.imagedetail.ImageDetailActivity
import vn.linh.wizelinephoto.screen.imagedetail.ImageDetailModule

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