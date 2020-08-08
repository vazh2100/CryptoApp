package com.vazheninapps.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.vazheninapps.cryptoapp.utils.convertTimeStampToTime


@Entity(tableName = "full_price_list")
data class CoinPriceInfo (

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String?,

    @SerializedName("PRICE")
    @Expose
    val price: Double?,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long?,

    @SerializedName("HIGHDAY")
    @Expose
    val highDay: Double?,

    @SerializedName("LOWDAY")
    @Expose
    val lowDay: Double?,

    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String?,

    @SerializedName("IMAGEURL")
    @Expose
    val imageURL: String?

)

{
   fun getFormattedTime():String{
      return convertTimeStampToTime(lastUpdate)
   }

    fun getFullImageUrl():String {
      return "https://cryptocompare.com/$imageURL"
    }
}