package com.vazheninapps.cryptoapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vazheninapps.cryptoapp.R
import com.vazheninapps.cryptoapp.pojo.CoinInfo
import com.vazheninapps.cryptoapp.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.item_coin_info.view.*

class CoinInfoAdapter(val context: Context) : RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList:List<CoinPriceInfo> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCoinClickListener:OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun getItemCount() = coinInfoList.size

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                tvSymbols.text = String.format(context.resources.getString(R.string.symbols), fromSymbol, toSymbol)
                tvPrice.text = price.toString()
                textViewTimeUpdate.text = String.format(context.resources.getString(R.string.last_update), getFormattedTime())
                Picasso.get().load(getFullImageUrl()).into(imLogoCoin)
                itemView.setOnClickListener{
                    onCoinClickListener?.onCoinClick(this)
                }
            }
        }


    }

    inner class CoinInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imLogoCoin = itemView.imageViewLogoCoin
        val tvSymbols = itemView.tvSymbols
        val tvPrice = itemView.tvPrice
        val textViewTimeUpdate = itemView.textViewTimeUpdate
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }
}