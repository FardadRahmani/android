package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


//EntryPoint into DB:
@Dao
abstract class WishDao {



    //onConflict for the case  we try  for same id to add another item or sth
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    //Loads all wishes from table
    @Query("Select * from 'wish-table'")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("Select * from 'wish-table' where id=:id")
    abstract fun getAWishById(id: Long): Flow<Wish>
}