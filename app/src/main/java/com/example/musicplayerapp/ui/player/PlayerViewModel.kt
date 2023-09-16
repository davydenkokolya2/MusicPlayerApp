package com.example.musicplayerapp.ui.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicplayerapp.domain.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {
    private val _statePlayer = MutableStateFlow<Song?>(null)
    val statePlayer: StateFlow<Song?> = _statePlayer
    fun loadState(song: Song) {
        viewModelScope.launch(Dispatchers.IO) {
            _statePlayer.emit(song)
        }
    }
    private val _statePlayerPlay = MutableStateFlow<Boolean>(false)
    val statePlayerPlay: StateFlow<Boolean> = _statePlayerPlay
    fun loadStatePlay(play: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _statePlayerPlay.emit(play)
        }
    }
}