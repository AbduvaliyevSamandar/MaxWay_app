package com.example.maxwayapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.maxwayapp.domain.entitydatabase.Cart

@Dao
interface CartDao {

    @Insert
    fun insert(cart: Cart)

    @Insert
    fun insertAll(carts: List<Cart>)

    @Query("SELECT * FROM cart")
    fun getCards():List<Cart>

    @Delete
    fun deletecard(cart:Cart)

    @Update
    fun updatecard(cart: Cart)

    @Query("DELETE FROM cart")
    fun nukeTable()


}
