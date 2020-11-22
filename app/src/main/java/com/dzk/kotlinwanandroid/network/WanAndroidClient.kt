package com.dzk.kotlinwanandroid.network

import com.xiangxue.kotlinproject.config.Flag
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author jackie
 * @date 2020/11/22
 * 访问服务器的API接口(WanAndroidAPI) 的 客户端管理
 */
class WanAndroidClient {
    private object Holder {
        val INSTANCE = WanAndroidClient()
    }

    companion object {
        val instance = Holder.INSTANCE
    }
    fun <T>  instanceRetrofit( apiInterface: Class<T>) : T{
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(10000,TimeUnit.MILLISECONDS)
            .connectTimeout(10000,TimeUnit.MILLISECONDS)
            .writeTimeout(10000,TimeUnit.MILLISECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Flag.BASE_URL1)
            .build()

        return retrofit.create(apiInterface)
    }
}