package com.example.mad_practical_5_21012011063

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.browse)
        val editBrowse : EditText = findViewById(R.id.url)
        btn.setOnClickListener {
            browser(editBrowse.text.toString())
        }

        val phn : Button = findViewById(R.id.call)
        val num : EditText = findViewById(R.id.phone)
        phn.setOnClickListener {
            call(num.text.toString())
        }

        val cal : Button = findViewById(R.id.calllog)
        cal.setOnClickListener {
            callLog()
        }

        val glr : Button = findViewById(R.id.gallery)
        glr.setOnClickListener {
            gallery()
        }
    }

    fun browser(url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }

    fun call(phone: String) {
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$phone")).also { startActivity(it) }
    }

    fun callLog() {
        Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).also { startActivity(it) }
    }

    fun gallery() {
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }

    fun camera() {

    }

    fun alarm() {

    }
}