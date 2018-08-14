package vn.linh.wizelinephoto.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    
}