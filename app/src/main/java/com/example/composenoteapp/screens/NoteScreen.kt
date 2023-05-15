package com.example.composenoteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composenoteapp.R
import androidx.compose.ui.res.stringResource
import com.example.composenoteapp.components.NoteTextInputField

@Composable
fun NoteScreen(){

    val titleTextState = remember{
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
            NoteTextInputField(text = titleTextState.value, label = "Title", onTextChange = {titleTextState.value = it})
        }
    }
}