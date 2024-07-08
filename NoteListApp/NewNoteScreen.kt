package com.example.newest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newest.model.Note
import com.example.newest.MainActivity
import com.example.newest.navigation.NoteViewModel

@Composable
fun NewNoteScreen(navController: NavController, viewModel: NoteViewModel){
    var noteTitle by remember{ mutableStateOf("") }
    var noteContent by remember{ mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize()) {


        OutlinedTextField(
            value = noteTitle,
            onValueChange = { noteTitle = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = noteContent,
            onValueChange = { noteContent = it },
            singleLine = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                viewModel.addNote(noteTitle, noteContent)
                noteTitle=""
                noteContent=""
                navController.navigate("notelistscreen")
            }) {
                Text(text = "Save")

            }
            Button(onClick = { navController.navigate("notelistscreen") }) {
                Text(text = "Cancel")

            }

        }
    }
}