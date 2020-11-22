package com.dzk.kotlinwanandroid.network

import android.content.Context
import com.dzk.kotlinwanandroid.entity.LoginResponse
import com.dzk.kotlinwanandroid.entity.LoginResponseWrapper
import com.dzk.kotlinwanandroid.util.LoadingDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author jackie
 * @date 2020/11/22
 * 拦截 自定义操作符，目的: 包装Bean 给拆成两份  如果成功  data--》UI
 * 如果失败  meg--》UI
 */
 abstract class APIResponse<T>(val context: Context) : Observer<LoginResponseWrapper<T>>{
    private var isShowDialog = true
    constructor(context: Context, isShowDialog:Boolean) : this(context) {
        this.isShowDialog = isShowDialog
    }

    abstract fun onSuccess(data : T)
    abstract fun onFail(errorMsg:String?)



    override fun onSubscribe(d: Disposable) {
        if(isShowDialog){
            LoadingDialog.show(context)
        }
    }

    override fun onNext(t: LoginResponseWrapper<T>) {
        if (t.data == null){
            onFail(t.errorMsg)
        }else {
            onSuccess(t.data)
        }

    }

    override fun onError(e: Throwable) {
        LoadingDialog.cancel()
        onFail(e.message)
    }

    override fun onComplete() {
        LoadingDialog.cancel()
    }
}