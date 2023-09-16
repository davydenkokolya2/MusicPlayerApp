package com.example.musicplayerapp.ui.playlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlaylistViewModel : ViewModel() {
    private val _statePlaylist = MutableStateFlow<Int?>(null)
    val statePlaylist: StateFlow<Int?> = _statePlaylist
    fun loadState(title: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _statePlaylist.emit(title)
        }
    }
}