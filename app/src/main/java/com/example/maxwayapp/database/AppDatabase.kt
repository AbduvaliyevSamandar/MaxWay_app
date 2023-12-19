package com.example.maxwayapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.maxwayapp.domain.entitydatabase.Cart

//, Description::class, Product::class, TitleX::class
@Database(entities = [Cart::class], version = 1)

abstract class AppDatabase:RoomDatabase() {
    abstract fun cartDao(): CartDao

}

class Database{
    companion object{
        private lateinit var appDatabase: AppDatabase

        fun getDatabase(context: Context): AppDatabase {
            if (!Companion::appDatabase.isInitialized){
                appDatabase = Room
                    .databaseBuilder(context, AppDatabase::class.java,"database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return appDatabase
        }
    }
}