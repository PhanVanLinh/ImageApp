package vn.linh.imageapp.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import vn.linh.imageapp.rx.AppSchedulerProvider
import vn.linh.imageapp.rx.SchedulerProvider
import javax.inject.Singleton

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Singleton
    @Binds
    abstract fun providerSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): SchedulerProvider
}