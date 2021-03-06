package vn.linh.imageapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.linh.ImageAppllication
import javax.inject.Singleton

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBuilderModule::class, NetworkModule::class, LocalModule::class, RepositoryModule::class])
interface AppComponent : AndroidInjector<ImageAppllication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}