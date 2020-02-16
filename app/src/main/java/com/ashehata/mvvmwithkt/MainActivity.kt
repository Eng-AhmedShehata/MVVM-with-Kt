package com.ashehata.mvvmwithkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init main viewmodel
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        insertData.setOnClickListener{v ->
            mainViewModel.username = userName.text.toString()
            mainViewModel.userPassword = userPassword.text.toString()
        }


        mainViewModel.isValid.observe(this, Observer { bool ->
            Toast.makeText(this, bool.toString(), Toast.LENGTH_LONG).show()
        })

    }
}
