package com.fajarbaihaqi.cryptopedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCryptos: RecyclerView
    private val list = ArrayList<Crypto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCryptos = findViewById(R.id.rv_cryptos)
        rvCryptos.setHasFixedSize(true)

        list.addAll(getListCryptos())
        showRecyclerList()
    }

    private fun getListCryptos(): ArrayList<Crypto>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCrypto = ArrayList<Crypto>()
        for (i in dataName.indices){
            val crypto = Crypto(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listCrypto.add(crypto)
        }
        return listCrypto
    }

    private fun showRecyclerList(){
        rvCryptos.layoutManager = LinearLayoutManager(this)
        val listCryptoAdapter = ListCryptoAdapter(list)
        rvCryptos.adapter = listCryptoAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.action_about -> {
                val intentMovetoAboutActivity = Intent(this, AboutActivity::class.java)
                startActivity(intentMovetoAboutActivity)
            }
            R.id.action_list -> {
                rvCryptos.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvCryptos.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}