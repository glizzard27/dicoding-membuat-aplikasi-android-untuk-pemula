package com.fajarbaihaqi.cryptopedia

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CryptoDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CRYPTO = "extra_crypto"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto_detail)

        supportActionBar?.hide()

        val dataCrypto = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Crypto>(EXTRA_CRYPTO, Crypto::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Crypto>(EXTRA_CRYPTO)
        }

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)

        if (dataCrypto != null) {
            tvDetailName.text = dataCrypto.name
            tvDetailDescription.text = dataCrypto.description
            ivDetailPhoto.setImageResource(dataCrypto.photo)
        } else {
            tvDetailName.text = "Error: Crypto data name not found !"
            tvDetailDescription.text = "Error: Crypto data description not found !"
        }
    }
}