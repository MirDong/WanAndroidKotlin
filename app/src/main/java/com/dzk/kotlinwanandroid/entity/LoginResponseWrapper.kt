package com.dzk.kotlinwanandroid.entity

/**
 * @author jackie
 * @date 2020/11/22
 */
/** 响应结果包装类 **/

/**
 * 包装Bean

  //成功
{
"data":{
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
},
"errorCode": 0,
"errorMsg": ""
}

//失败
{
"data": null,
"errorCode": -1,
"errorMsg": "账号密码不匹配！"
}
 */
data class LoginResponseWrapper<T>(val data:T,val errorCode:Int,val errorMsg:String)