package com.alirizakaygusuz.horoscopelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import com.alirizakaygusuz.horoscopelist.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        configSplashAnimation()
    }

    fun configSplashAnimation() {
        var logodonduranim = AnimationUtils.loadAnimation(this, R.anim.rotate_circle_horo)


        binding.imvCirleHoro.animation = logodonduranim

        window.statusBarColor = resources.getColor(R.color.color_default)
    }

    override fun onResume() {
        object : CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            }

        }.start()
        super.onResume()

    }
}