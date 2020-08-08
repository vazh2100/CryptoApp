package com.vazheninapps.cryptoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vazheninapps.cryptoapp.pojo.CoinPriceInfo


@Database(entities = [CoinPriceInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {


    companion object{
        private var db:AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context):AppDatabase {
            synchronized(LOCK){
            db?.let { return it }
            val instance = Room
                .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .allowMainThreadQueries()
                .build()
            db = instance
            return instance}
        }



    }

    abstract fun coinPriceInfoDao():CoinPriceInfoDao

}