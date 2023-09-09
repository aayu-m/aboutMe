package com.kotlinapps.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.kotlinapps.aboutme.databinding.ActivityMainBinding

data class MyName( var name : String ="", var nickname : String ="")

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName : MyName = MyName("Aayushi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }
        binding.myName = myName

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val editText = binding.nicknameEdit
        val nickname = binding.nicknameText

//        nickname.text= editText.text
        myName?.nickname = editText.text.toString()
        Log.d("value", myName.toString())
        binding.invalidateAll()
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickname.visibility = View.VISIBLE


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }


}