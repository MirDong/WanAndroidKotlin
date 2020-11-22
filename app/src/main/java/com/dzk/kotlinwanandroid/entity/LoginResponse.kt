package com.dzk.kotlinwanandroid.entity

/**
 * @author jackie
 * @date 2020/11/22
 * data 登录成功 需要把这个Bean 给 UI
 */

/**
 *"data":{
"admin": false,
"chapterTops":[],
"coinCount": 0,
"collectIds":[9111, 8995],
"email": "",
"icon": "",
"id": 35069,
"nickname": "jackie",
"password": "",
"publicName": "jackie",
"token": "",
"type": 0,
"username": "jackie"
}
 */
data class LoginResponse(
    val admin:Boolean,
    val chapterTops:List<*>,
    val coinCount:Int,
    val collectIds:List<*>,
    val email:String?,
    val icon: String?,
    val id: String?,
    val nickname: String?,
    val password: String?,
    val publicName: String?,
    val token: String?,
    val type: Int,
    val username: String?
    )