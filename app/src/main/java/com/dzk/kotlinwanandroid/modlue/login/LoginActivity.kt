package com.dzk.kotlinwanandroid.modlue.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dzk.kotlinwanandroid.R
import com.dzk.kotlinwanandroid.api.WanAndroidAPI
import com.dzk.kotlinwanandroid.entity.LoginResponse
import com.dzk.kotlinwanandroid.network.APIResponse
import com.dzk.kotlinwanandroid.network.WanAndroidClient
import com.xiangxue.kotlinproject.config.Flag
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_user_login.*
/**
 * @author jackie
 * @date 2020/11/22
 * 登录界面
 */
class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
        user_login_bt.setOnClickListener(onClickListener)
    }

    /*private val onClickListener = View.OnClickListener {

    } */

    private val onClickListener = object : View.OnClickListener{
        override fun onClick(view: View?) {
            when(view?.id){
                R.id.user_login_bt -> {
                    val userName = user_phone_et.text.toString()
                    val password = user_password_et.text.toString()
                    Log.d(Flag.TAG, "userName:$userName,  userPwd:$password")
                    WanAndroidClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
                        .login(userName,password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : APIResponse<LoginResponse>(this@LoginActivity){
                            override fun onSuccess(data: LoginResponse) {
                                Log.e(Flag.TAG, "success: $data")
                                Toast.makeText(this@LoginActivity, "登录成功😀", Toast.LENGTH_SHORT).show()
                            }

                            override fun onFail(errorMsg: String?) {
                                // 失败 msg UI
                                Log.e(Flag.TAG, "failure: errorMsg:$errorMsg")
                                Toast.makeText(this@LoginActivity, "登录失败 ~ 呜呜呜", Toast.LENGTH_SHORT).show()
                            }
                        })
                }
            }
        }
    }
}