package com.dzk.kotlinwanandroid.modlue.login.inter

import android.content.Context

/**
 * @author jackie
 * @date 2020/11/22
 */
interface LoginModel {
    // 取消请求 动作
    fun cancelRequest()
    //登录
    fun login(context: Context,
              username: String,
              password: String,

        // 接口回调，把data 结果，给P层
              onLoginListener: LoginPresenter.OnLoginListener
    )
}