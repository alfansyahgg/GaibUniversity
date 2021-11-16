package com.example.gaibuniversity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import com.example.gaibuniversity.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        val fadein = AnimationUtils.loadAnimation(this,R.anim.fade_in_animation)
        val fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop)
        val slidefromleft = AnimationUtils.loadAnimation(this,R.anim.slide_from_left)
        val slidefromright = AnimationUtils.loadAnimation(this,R.anim.slide_from_right)

        binding.ivIcon.startAnimation(fadein)
        binding.tvSignin.startAnimation(fadein)
        binding.rlWrapper.startAnimation(slidefromleft)

        Log.d("Cek","Hello there!")

        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }

    }
}