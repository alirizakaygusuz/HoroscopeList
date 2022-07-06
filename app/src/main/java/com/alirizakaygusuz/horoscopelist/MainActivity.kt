package com.alirizakaygusuz.horoscopelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alirizakaygusuz.horoscopelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createHoroscopesInformation()
    }

    private fun createHoroscopesInformation() {
        val horoscopeList =  ArrayList<Horoscope>()

        val horoscopes =  this.resources.getStringArray(R.array.horoscopes)





        val horoscopeDate =  this.resources.getStringArray(R.array.horoscopeDate)

        val horoscopeEqualsElement = this.resources.getStringArray(R.array.horoscopeEqualsElement)

        val horoscopeDetails = this.resources.getStringArray(R.array.horoscopeDetails)

        val hArrayLogo =  this.resources.obtainTypedArray(
            R.array.horoscopeLogo)

        val hArrayElement =  this.resources.obtainTypedArray(
            R.array.horoscopeElement)

        val hArrayBigImage =  this.resources.obtainTypedArray(
            R.array.horoscopeBigImage)

        val horoscopeBigImage =IntArray(horoscopeEqualsElement.size)
        for(i in 0 until horoscopeEqualsElement.size){
            horoscopeBigImage[i] = hArrayBigImage.getResourceId(i, 0)

        }



        val countElement = hArrayElement.length()
        val horoscopeElementLogo =IntArray(countElement)

        val horoscopeElements =IntArray(horoscopeEqualsElement.size)

        for(i in 0 until countElement){
            horoscopeElementLogo[i] = hArrayElement.getResourceId(i, 0)

        }


        for(i in 0 until horoscopeEqualsElement.size){
            if(horoscopeEqualsElement[i].toString().equals("Hava")){
                horoscopeElements[i] = horoscopeElementLogo[0]
            }else if(horoscopeEqualsElement[i].toString().equals("Toprak")){
                horoscopeElements[i] = horoscopeElementLogo[1]

            }else if(horoscopeEqualsElement[i].toString().equals("Ateş")){
                horoscopeElements[i] = horoscopeElementLogo[2]

            }else{
                horoscopeElements[i] = horoscopeElementLogo[3]

            }

        }

        val count = hArrayLogo.length()


        val horoscopeSymbols =IntArray(count)


        for(i in 0 until count){
            horoscopeSymbols[i] = hArrayLogo.getResourceId(i, 0)
        }


        for (i in horoscopes.indices){

            val tmpHoroscope = Horoscope(horoscopes[i], horoscopeDate[i] , horoscopeSymbols[i] , horoscopeDetails[i],horoscopeEqualsElement[i],horoscopeElements[i], horoscopeBigImage[i])
            horoscopeList.add(tmpHoroscope)
        }

        val adapter = HoroscopeBaseAdapter(horoscopeList)

        binding.listviewHoroscopes.adapter = adapter



        binding.listviewHoroscopes.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity , DetailsActivity::class.java)
            intent.putExtra("horoscope", horoscopeList[i])
            startActivity(intent)
        }


        window.statusBarColor = resources.getColor(R.color.color_default)
    }
}