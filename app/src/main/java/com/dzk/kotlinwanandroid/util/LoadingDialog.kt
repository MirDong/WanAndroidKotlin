package com.dzk.kotlinwanandroid.util

import android.app.Dialog
import android.content.Context
import com.dzk.kotlinwanandroid.R

/**
 * @author jackie
 * @date 2020/11/22
 */
// object 没有主构造 也没有次构造
object LoadingDialog {
    private var dialog:Dialog? = null
    //真正的static
    @JvmStatic
    fun show(context: Context){
        dialog = Dialog(context)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }

    fun cancel(){
        dialog?.dismiss()
    }
}