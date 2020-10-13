/*
@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.skillbox.android

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.activity.invoke
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity(R.layout.activity_second) {

    private val launcher = prepareCall(ActivityResultContracts.Dial()) { ok ->
        if (ok) {
            toast("Спасибо, что позвонили! Ваш звонок важен для нас!")
        } else {
            toast("Передумал?")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        messageCallNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkNumber()
            }
        })


        callNumber.setOnClickListener {

            val num = messageCallNumber.text.toString()
            checkCallNumber(num)
        }

    }

    private fun checkCallNumber(num: String) {
        val isNumberCorrect = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
        if (!isNumberCorrect) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 666)
        } else {
            launcher(num)
        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun checkNumber() {
        val number = messageCallNumber.text.toString()

        val isNumberCorrect = Patterns.PHONE.matcher(number).matches()
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val KEY_MESSAGE = "message key"

        fun getIntent(context: Context, message: String?): Intent {
            return Intent(context, SecondActivity::class.java).putExtra(KEY_MESSAGE, message)
        }
    }

}*/
