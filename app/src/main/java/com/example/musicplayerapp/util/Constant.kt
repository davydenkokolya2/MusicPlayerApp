package com.example.musicplayerapp.util

import com.example.musicplayerapp.R
import com.example.musicplayerapp.domain.Song

object Constant {
    val firstPlaylist = listOf<Song>(
        Song(
            R.drawable.icon_image,
            R.string.title_song_1_playlist_1,
            R.string.author_song_1_playlist_1,
            R.raw.music1
        ),
        Song(
            R.drawable.icon_image,
            R.string.title_song_2_playlist_1,
            R.string.author_song_2_playlist_1,
            R.raw.music2
        ),
        Song(
            R.drawable.icon_image,
            R.string.title_song_3_playlist_1,
            R.string.author_song_3_playlist_1,
            R.raw.music3
        ),
        Song(
            R.drawable.icon_image,
            R.string.title_song_4_playlist_1,
            R.string.author_song_4_playlist_1,
            R.raw.music1
        ),
        Song(
            R.drawable.icon_image,
            R.string.title_song_5_playlist_1,
            R.string.author_song_5_playlist_1,
            R.raw.music2
        ),
        Song(
            R.drawable.icon_image,
            R.string.title_song_6_playlist_1,
            R.string.author_song_6_playlist_1,
            R.raw.music3
        ),
        Song(
            R.drawable.icon_image,
            R.string.title_song_7_playlist_1,
            R.string.author_song_7_playlist_1,
            R.raw.music1
        ),
    )
    val favouriteList = mutableListOf<Song>()
    val recentlyList = mutableListOf<Song>(
        firstPlaylist[0],
        firstPlaylist[1],
        firstPlaylist[2],
        firstPlaylist[3]
    )
}