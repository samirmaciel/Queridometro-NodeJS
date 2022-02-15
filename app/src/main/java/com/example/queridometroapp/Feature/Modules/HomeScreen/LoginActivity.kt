package com.example.queridometroapp.Feature.Modules.HomeScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.queridometroapp.R
import com.example.queridometroapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var _binding : ActivityLoginBinding? = null
    private val binding : ActivityLoginBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        binding.btnEnter.setOnClickListener{
            if(!binding.etEnterName.text.toString().isBlank() || !binding.etEnterName.text.toString().isEmpty()){
                val intent = Intent(this, HomeScreen::class.java)
                intent.putExtra("userName", binding.etEnterName.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "Por favor entre com seu nome!", Toast.LENGTH_SHORT).show()
            }


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}