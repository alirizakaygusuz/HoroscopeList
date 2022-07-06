package com.alirizakaygusuz.horoscopelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class HoroscopeBaseAdapter(var horoscopeList: ArrayList<Horoscope>): BaseAdapter() {

    override fun getCount(): Int {
        return horoscopeList.size
    }

    override fun getItem(position: Int): Any {
        return horoscopeList.get(position)
    }


    override fun getItemId(position: Int): Long {

        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var horoscope_row = convertView
        var viewHolder: HoroscopeBaseAdapter.ViewHolder? = null


        if (horoscope_row == null) {
            val inflater = LayoutInflater.from(parent?.context)
            horoscope_row = inflater.inflate(R.layout.horoscope_row, parent, false)

            viewHolder = HoroscopeBaseAdapter.ViewHolder(horoscope_row)

            horoscope_row.tag = viewHolder

        } else {
            viewHolder = horoscope_row.tag as HoroscopeBaseAdapter.ViewHolder

        }




        viewHolder.horoscopeImage.setImageResource(horoscopeList.get(position).horoscopeImage)
        viewHolder.horoscopeName.text = horoscopeList.get(position).horoscopeName
        viewHolder.horoscopeDate.text = horoscopeList.get(position).horoscopeDate
        viewHolder.horoscopeElementLogo.setImageResource(horoscopeList.get(position).horoscopeElement)








        return horoscope_row!!

    }

    class ViewHolder(teksatirView: View) {
        var horoscopeImage: ImageView
        var horoscopeName: TextView
        var horoscopeDate: TextView
        var horoscopeElementLogo: ImageView

        init {
            this.horoscopeImage = teksatirView.findViewById<ImageView>(R.id.imvHoroscopeSymbol)
            this.horoscopeName = teksatirView.findViewById<TextView>(R.id.txtHoroscopeName)
            this.horoscopeDate = teksatirView.findViewById<TextView>(R.id.txtHoroscopeDate)
            this.horoscopeElementLogo = teksatirView.findViewById<ImageView>(R.id.imvHoroscopeElementLogo)
        }


    }
}