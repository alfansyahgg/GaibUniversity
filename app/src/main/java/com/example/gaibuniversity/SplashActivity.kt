package com.example.gaibuniversity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.gaibuniversity.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 2500
    lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val iv_splash = binding.ivSplash
        val fadein = AnimationUtils.loadAnimation(this,R.anim.fade_in_animation)

        iv_splash.startAnimation(fadein)
        binding.tvTitle.startAnimation(fadein)
        binding.tvSubtitle.startAnimation(fadein)

        Handler().postDelayed({
                    val intent = Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                    finish()
        }, SPLASH_TIME_OUT.toLong())

    }

}