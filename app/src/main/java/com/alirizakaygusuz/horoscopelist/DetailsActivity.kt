package com.alirizakaygusuz.horoscopelist

import android.R
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.palette.graphics.Palette
import com.alirizakaygusuz.horoscopelist.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setHoroscopeDetails()
        window.statusBarColor =
            resources.getColor(com.alirizakaygusuz.horoscopelist.R.color.color_default)

    }

    fun setHoroscopeDetails() {
        val selectedHoroscope = intent.getSerializableExtra("horoscope") as Horoscope



        binding.txtHoroscopeProperties.text = selectedHoroscope.horoscopeDetails
        binding.header.setImageResource(selectedHoroscope.horoscopeBigImage)


        setSupportActionBar(binding.animToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)






        binding.collapsingToolbar.setTitle(selectedHoroscope.horoscopeName)


        val bitmap = BitmapFactory.decodeResource(resources,
            selectedHoroscope.horoscopeBigImage)

        Palette.from(bitmap).generate { palette ->

            val vibrantColor = palette!!.getVibrantColor(R.attr.colorAccent)



            binding.collapsingToolbar.setContentScrimColor(vibrantColor)
            binding.collapsingToolbar.setStatusBarScrimColor(vibrantColor)

            window.statusBarColor = vibrantColor
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}