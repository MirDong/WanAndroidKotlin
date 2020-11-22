package com.dzk.kotlinwanandroid.api

import com.dzk.kotlinwanandroid.entity.LoginResponse
import com.dzk.kotlinwanandroid.entity.LoginResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author jackie
 * @date 2020/11/22
 */
//客户端API
interface WanAndroidAPI {
    @POST("/user/login")
    @FormUrlEncoded
    fun login(@Field("username") username:String,
    @Field("password") password:String):Observable<LoginResponseWrapper<LoginResponse>>
}