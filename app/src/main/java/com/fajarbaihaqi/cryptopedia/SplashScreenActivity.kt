package com.fajarbaihaqi.cryptopedia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        val ivSplashScreen: ImageView = findViewById(R.id.iv_splashScreen)
        ivSplashScreen.alpha = 0f
        ivSplashScreen.animate().setDuration(1500).alpha(1f).withEndAction{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

        val tvSplashScreen: TextView =findViewById(R.id.tv_splashScreen)
        tvSplashScreen.alpha = 0f
        tvSplashScreen.animate().setDuration(1500).alpha(1f).withEndAction{

        }
    }
}