package vn.linh.imageapp.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import vn.linh.imageapp.data.source.local.api.SharedPrefApi
import javax.inject.Singleton

@Module
class LocalModule {

    @Singleton
    @Provides
    fun provideSharedPrefApi(context: Context, gson: Gson): SharedPrefApi {
        return SharedPrefApi(context, gson)
    }
}