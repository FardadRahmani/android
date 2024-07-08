package com.example.newest.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.newest.model.Note

class NoteViewModel : ViewModel() {
    private val _notes = mutableStateListOf<Note>()
    val notes: SnapshotStateList<Note> = _notes

    fun addNote(title: String, content: String) {
        val newNote = Note(_notes.size + 1, title, content)
        _notes.add(newNote)
    }

    fun updateNote(noteId: Int, updatedTitle: String, updatedContent: String) {
        val noteIndex = _notes.indexOfFirst { it.id == noteId }
        if (noteIndex != -1) {
            _notes[noteIndex] = _notes[noteIndex].copy(
                title = updatedTitle,
                content = updatedContent
            )
        }
    }
}