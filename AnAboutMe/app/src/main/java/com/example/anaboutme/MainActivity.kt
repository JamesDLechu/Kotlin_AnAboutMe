package com.example.anaboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var nickname_edit: EditText
    lateinit var nickname_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname( it )
        }

        nickname_edit= findViewById(R.id.nickname_edit)
        nickname_text= findViewById(R.id.nickname_text)
    }

    private fun addNickname(view: View){
        nickname_edit.visibility= View.GONE
        nickname_text.visibility= View.VISIBLE
        view.visibility= View.GONE

        nickname_text.text= nickname_edit.text
        //Hide keyboard
        val imm= getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}