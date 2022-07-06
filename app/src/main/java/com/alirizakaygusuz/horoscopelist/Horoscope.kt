package com.alirizakaygusuz.horoscopelist

import java.io.Serializable

data class Horoscope( var horoscopeName: String,
                      var horoscopeDate: String,
                      var horoscopeImage: Int,
                      var horoscopeDetails: String,
                      var horoscopeEqualsElement: String,
                      var horoscopeElement: Int,
                      var horoscopeBigImage: Int,
) : Serializable {

}