package com.qbitscience.auto_fill_otp_verification_master
import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      // first prompt user to grant required permissions
        grantRequiredPermissions()

    // call our receiver and send pin view to the receiver
        MyOTP_reciever().setEditText(otp_digits)


    }

    private fun grantRequiredPermissions() {
        val requiredSMSPermission = Manifest.permission.RECEIVE_SMS
        val grant = ContextCompat.checkSelfPermission(this, requiredSMSPermission)
        //check if read SMS permission is granted or not
        if (grant != PackageManager.PERMISSION_GRANTED) {
            val permission_list = arrayOfNulls<String>(1)
            permission_list[0] = requiredSMSPermission
            ActivityCompat.requestPermissions(this, permission_list, 1)
        }    }
}