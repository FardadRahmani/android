package com.example.roomdbexample.roomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

//Data Access Object
@Dao
interface RoomDao {
    //Here we create all functions
    //on how to interact with DB
    //For each activity we wish to do: 1 function
    //Like: 1. insert Data 2.update data 3.delete Data 4.retrieve all data
    //New: 5.upsert (mix of insert and update)


    @Upsert
    suspend fun upsertNote (note: Note)

    @Delete
    suspend fun deleteNote (note: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes () : Flow<List<Note>>

}