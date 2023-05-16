package com.example.composenoteapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composenoteapp.R
import com.example.composenoteapp.components.NoteButton
import com.example.composenoteapp.components.NoteTextInputField
import com.example.composenoteapp.models.Note

@Composable
fun NoteScreen(
    notes: List<Note>,
    addNote: (Note) -> Unit,
    removeNote: (Note) -> Unit
){

    val titleTextState = remember{
        mutableStateOf("")
    }

    var descTextState by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            actions = {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Icon")
            },
            backgroundColor = Color(0xFF8AA6BD)
        )

        //Content
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            NoteTextInputField(
                modifier= Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = titleTextState.value,
                label = "Title",
                onTextChange = {
                    if(it.all {char -> char.isLetter() || char.isWhitespace()}){
                        titleTextState.value = it
                    }
                }
            )

            NoteTextInputField(
                modifier= Modifier.padding(top = 9.dp, bottom = 8.dp),
                text = descTextState,
                label = "Description",
                onTextChange = {descTextState = it}
            )

            NoteButton(
                text = "Save",
                onClick = {
                    if(titleTextState.value.isNotEmpty() && descTextState.isNotEmpty()){
                        // save the data
                        titleTextState.value = ""
                        descTextState = ""
                    }
                }
            )
        }

        // Notes list

        Divider(modifier = Modifier.padding(8.dp))

        LazyColumn(){
            items(notes){ note ->
                NoteRow(note = note, onNoteClicked = {})
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
){
    Surface(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(topEnd = 32.dp, bottomStart = 32.dp)
            ),
        color = Color(0XFFDFE6EB),
        elevation = 8.dp
    ) {
        Column(modifier = modifier
            .clickable { onNoteClicked(note) }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.Start,
        ) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.desc, style = MaterialTheme.typography.subtitle1)
            Text(text = note.entryTimeStamp.toString(), style = MaterialTheme.typography.caption)
        }
    }
}