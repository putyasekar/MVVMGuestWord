package com.diki.idn.mvvmguestword

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.diki.idn.mvvmguestword.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    private val name: NameValue = NameValue("Putya Sekar Ayu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.nameValue = name
        dataBinding.btnSubmit.setOnClickListener { attachName(it) }
        dataBinding.value.setOnClickListener { updateName(it) }
    }

    private fun updateName(it: View) {
//        val userEvent = findViewById<EditText>(R.id.et_guest_name)
//        val buttonSubmit = findViewById<Button>(R.id.btn_submit)

        dataBinding.apply {
            nameValue?.valueName = etGuestName.text.toString()
            btnSubmit.visibility = View.VISIBLE
            it.visibility = View.GONE
            etGuestName.requestFocus()
        }

        val hideKeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboard.hideSoftInputFromWindow(it.windowToken, 0)
    }

    private fun attachName(it: View) {
//        val userEvent = findViewById<EditText>(R.id.et_guest_name)
//        val textValue = findViewById<TextView>(R.id.value)

        dataBinding.apply {
            nameValue?.valueName = etGuestName.text.toString()
            invalidateAll()
            etGuestName.visibility = View.GONE
            btnSubmit.visibility = View.GONE
            value.visibility = View.VISIBLE
        }

        val hideKeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboard.hideSoftInputFromWindow(it.windowToken, 0)


    }
}
