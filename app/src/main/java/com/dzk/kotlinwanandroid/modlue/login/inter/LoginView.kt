package com.dzk.kotlinwanandroid.modlue.login.inter

import android.content.Context
import com.dzk.kotlinwanandroid.entity.LoginResponse

/**
 * @author jackie
 * @date 2020/11/22
 * View层
 */
interface LoginView {

  fun loginSuccess(loginResult:LoginResponse?)
  fun loginFail(errorMsg:String?)

}