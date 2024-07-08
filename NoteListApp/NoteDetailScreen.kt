package com.example.newest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newest.navigation.NoteViewModel


@Composable
fun NoteDetailScreen(navController: NavController, viewModel: NoteViewModel, noteId: Int) {
    val note = viewModel.notes[noteId]
    var noteTitle by remember { mutableStateOf(note.title) }
    var noteContent by remember { mutableStateOf(note.content) }



    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {


            Card(
                modifier = Modifier
                    .width(250.dp)
                    .height(370.dp),
                // shape = CutCornerShape(20.dp)
                elevation = CardDefaults.cardElevation(10.dp),
                //border = BorderStroke(3.dp,Color.Gray)
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column {




                        OutlinedTextField(
                        value = noteTitle,
                        onValueChange = { noteTitle = it },
                        label = { Text("Title") },
                        modifier = Modifier.fillMaxWidth(),


                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = noteContent,
                        onValueChange = { noteContent = it },
                        label = { Text("Content") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        maxLines = 5
                    )



                }

            }
            
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                Button(onClick = {
                    viewModel.updateNote(noteId+1, noteTitle, noteContent)
                    //viewModel.notes[noteId].title = noteTitle
                    //viewModel.notes[noteId].content = noteContent
                    noteTitle= ""
                    noteContent = ""
                    navController.navigate("notelistscreen")

                }) {
                    Text(text = "Save")
                }
                IconButton(onClick = { viewModel.deleteNote(noteId+1)
                    navController.navigate("notelistscreen")
                }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Menu icon" )
                }
                Button(onClick = {
                    noteTitle= ""
                    noteContent = ""
                    navController.navigate("notelistscreen") }) {
                    Text(text = "Go Back")
                }
                
            }
            Text(text = "Size of list: ${viewModel.notes.size}", modifier = Modifier.fillMaxWidth())
            Text(text = "Id passed: $noteId", modifier = Modifier.fillMaxWidth())
        }

    }
}