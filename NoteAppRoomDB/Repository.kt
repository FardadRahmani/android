package com.example.roomdbexample.viewModel

import androidx.room.RoomDatabase
import com.example.roomdbexample.roomDB.Note
import com.example.roomdbexample.roomDB.NoteDatabase


class Repository(private val db : NoteDatabase) {


    suspend fun upsertNote (note: Note){
        db.dao.upsertNote(note)
    }


    suspend fun deleteNote (note: Note){
        db.dao.deleteNote(note)
    }


    fun getAllNotes () = db.dao.getAllNotes()

}