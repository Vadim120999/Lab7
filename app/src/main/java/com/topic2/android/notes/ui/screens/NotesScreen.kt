package com.topic2.android.notes.ui.screens

import androidx.compose.runtime.Composable
import com.topic2.android.notes.viewmodel.MainViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import com.topic2.android.notes.ui.components.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.topic2.android.notes.domain.model.NoteModel
import com.topic2.android.notes.ui.components.Note

@Composable
fun NotesScreen(
    viewModel: MainViewModel
){
    val notes: List<NoteModel> by viewModel
        .notesNotInTrash
        .observeAsState(listOf())
    Column {
        TopAppBar(title = "Заметки" ,
            icon = Icons.Filled.List,
            onIconClick ={}
        )

        LazyColumn {
            items(count = notes.size) { noteIndex -> val note = notes[noteIndex]
                Note(
                    note = note,
                    onNoteClick = {viewModel.onNoteClick(it)},
                    onNoteCheckedChange = {viewModel.onNoteCheckedChange(it)}
                )
            }
        }
    }
}
