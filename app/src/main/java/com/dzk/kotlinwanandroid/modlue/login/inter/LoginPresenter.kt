package com.dzk.kotlinwanandroid.modlue.login.inter

import android.content.Context
import com.dzk.kotlinwanandroid.entity.LoginResponse

/**
 * @author jackie
 * @date 2020/11/22
 */
interface LoginPresenter {
    fun login(context: Context,
              username: String,
              password: String)

    interface OnLoginListener {
        fun loginSuccess(loginResult: LoginResponse?)
        fun loginFail(errorMsg:String?)
    }
}