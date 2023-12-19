package com.example.maxwayapp.domain.entitydatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
class Cart(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val imagecart:String,
    val titlecart:String,
    val desc:String,
    val count:String,
    val amount:String
)