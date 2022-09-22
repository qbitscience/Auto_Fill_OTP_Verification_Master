package com.qbitscience.auto_fill_otp_verification_master

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import android.widget.EditText


class MyOTP_reciever : BroadcastReceiver() {

    companion object {
        private var editText: EditText? = null
    }
    fun setEditText(editText: EditText?) {
        Companion.editText = editText
    }

    // OnReceive will keep trace when sms is been received in mobile
    override fun onReceive(context: Context, intent: Intent) {
        //message will be holding complete sms that is received
        val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        for (sms in messages) {
            val msg = sms.messageBody
            // here you can split your OTP message according
            // to your choice ex  space,colon(:),hyphen(-)
            // in this we have slpit our text according to space and
            // when the OTP is at the 1st index as array starts with 0
            val otp = msg.split(" ".toRegex()).toTypedArray()[1]
            editText!!.setText(otp)
            Log.d("otp_Test",otp)
        }
    }

}