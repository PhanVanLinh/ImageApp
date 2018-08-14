package vn.linh.wizelinephoto.di

import android.content.Context
import dagger.Module
import dagger.Provides
import vn.linh.wizelinephoto.data.source.local.api.SharedPreferenceApi

/**
 * Created by PhanVanLinh on 8/14/2018.
 * phanvanlinh.94vn@gmail.com
 */
@Module
class LocalModule {

    @Provides
    fun provideSharePreference(context: Context): SharedPreferenceApi {
        return SharedPreferenceApi(context)
    }
}