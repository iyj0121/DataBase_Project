package com.example.planner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.planner.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        val ButtonLogin = binding.butLogin

        setContentView(binding.root)

        var projectTitle = binding.editId
        var projectContent = binding.editPassword

        ButtonLogin.setOnClickListener {
            if(projectTitle.text.toString() == "1"){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}