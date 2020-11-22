package com.dzk.kotlinwanandroid.modlue.login.impl

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.dzk.kotlinwanandroid.api.WanAndroidAPI
import com.dzk.kotlinwanandroid.entity.LoginResponse
import com.dzk.kotlinwanandroid.modlue.login.inter.LoginModel
import com.dzk.kotlinwanandroid.modlue.login.inter.LoginPresenter
import com.dzk.kotlinwanandroid.network.APIResponse
import com.dzk.kotlinwanandroid.network.WanAndroidClient
import com.xiangxue.kotlinproject.config.Flag
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author jackie
 * @date 2020/11/22
 */
class LoginModelImpl : LoginModel{
    override fun cancelRequest() {
        TODO("Not yet implemented")
    }

    override fun login(
        context: Context,
        username: String,
        password: String,
        onLoginListener: LoginPresenter.OnLoginListener
    ) {
        WanAndroidClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .login(username,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APIResponse<LoginResponse>(context){
                override fun onSuccess(data: LoginResponse) {
                    Log.e(Flag.TAG, "success: $data")
                    onLoginListener.loginSuccess(data)
                }

                override fun onFail(errorMsg: String?) {
                    // 失败 msg UI
                    Log.e(Flag.TAG, "failure: errorMsg:$errorMsg")
                    onLoginListener.loginFail(errorMsg)
                }
            })
    }
}