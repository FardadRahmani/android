package com.example.newest.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newest.model.Note
import com.example.newest.navigation.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(navController: NavController, viewModel: NoteViewModel){





    Column(modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            navController.navigate("newnotescreen")

        }) {
            Text(text = "+ Add Note", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(viewModel.notes){
                note->

                Card(onClick = {
                    if (note.id <= viewModel.notes.size){
                        navController.navigate("notedetailscreen?id=${note.id-1}")}
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Cyan
                    ),

                ) {




                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = note.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                            Text(
                                text = note.content,
                                fontSize = 18.sp
                            )
                        }



                }


            }

        }

    }


}















/*if (showDialog == true){
        AlertDialog(onDismissRequest = { showDialog=false },
            confirmButton = {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = {
                        if (noteTitle.isNotBlank())
                        {
                            val newNote = Note(
                                id = notes.size+1,
                                title = noteTitle,
                                content = noteContent)
                            notes += newNote
                            noteTitle = ""
                            noteContent = ""
                            showDialog = false

                        }
                    }) {
                        Text(text = "Add")
                    }
                    Button(onClick = { showDialog = false }) {
                        Text(text = "Cancel")
                    }
                }
            },
            title = { Text(text = "Add Note")},
            text = {
                Column {
                    OutlinedTextField(value = noteTitle,
                        onValueChange = {noteTitle=it},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp))
                    OutlinedTextField(value = noteContent,
                        onValueChange = {noteContent = it},
                        singleLine = false,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp))
                }
            }
        )

    }*/