package vn.linh.imageapp.screen.splash

import dagger.Binds
import dagger.Module
import vn.linh.imageapp.di.scope.ActivityScope

@Module
abstract class SplashModule {

    @Binds
    @ActivityScope
    abstract fun bindSplashPresenter(splashPresenter: SplashPresenter): SplashContract.Presenter

    @Binds
    @ActivityScope
    abstract fun bindSplashView(splashActivity: SplashActivity): SplashContract.View
}