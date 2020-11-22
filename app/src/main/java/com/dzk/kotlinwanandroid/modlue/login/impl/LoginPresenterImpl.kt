package com.dzk.kotlinwanandroid.modlue.login.impl

import android.content.Context
import com.dzk.kotlinwanandroid.entity.LoginResponse
import com.dzk.kotlinwanandroid.modlue.login.inter.LoginModel
import com.dzk.kotlinwanandroid.modlue.login.inter.LoginPresenter
import com.dzk.kotlinwanandroid.modlue.login.inter.LoginView

/**
 * @author jackie
 * @date 2020/11/22
 */
class LoginPresenterImpl(val loginView: LoginView ?) : LoginPresenter,LoginPresenter.OnLoginListener{
    private val mLoginModel:LoginModel = LoginModelImpl()
    override fun login(context: Context, username: String, password: String) {
        mLoginModel.login(context,username,password,this)
    }
    // 接收 Model 的结果
    override fun loginSuccess(loginResult: LoginResponse?) {
        loginView?.loginSuccess(loginResult)
    }

    override fun loginFail(errorMsg: String?) {
        loginView?.loginFail(errorMsg)
    }
}