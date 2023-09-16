package com.example.musicplayerapp.ui

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.musicplayerapp.R
import com.example.musicplayerapp.ui.favourite.FavouriteFragment
import com.example.musicplayerapp.ui.home.HomeFragment
import com.example.musicplayerapp.ui.onboarding.OnboardingFragment
import com.example.musicplayerapp.ui.player.PlayerFragment
import com.example.musicplayerapp.ui.player.PlayerViewModel
import com.example.musicplayerapp.ui.playlist.PlaylistFragment
import com.example.musicplayerapp.util.Graph
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private val playerViewModel: PlayerViewModel by viewModels()
    private val graphViewModel: GraphViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            graphViewModel.stateGraph.collect {
                when (it) {
                    Graph.HOME -> replaceFragment(HomeFragment())
                    Graph.FAVOURITE -> replaceFragment(FavouriteFragment())
                    Graph.PLAYER -> replaceFragment(PlayerFragment())
                    Graph.PLAYLIST -> replaceFragment(PlaylistFragment())
                    Graph.ONBOARDING -> replaceFragment(OnboardingFragment())
                }
            }
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.music1)
        lifecycleScope.launch {
            playerViewModel.statePlayerPlay.collect {
                when (it) {
                    true -> {
                        mediaPlayer = MediaPlayer.create(
                            this@MainActivity,
                            playerViewModel.statePlayer.value!!.song
                        )
                        mediaPlayer.isLooping = true
                        mediaPlayer.start()
                    }

                    false -> {
                        mediaPlayer.pause()
                    }
                }
            }
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}