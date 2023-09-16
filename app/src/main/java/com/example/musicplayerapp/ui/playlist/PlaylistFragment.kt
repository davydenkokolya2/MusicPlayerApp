package com.example.musicplayerapp.ui.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayerapp.databinding.FragmentPlaylistBinding
import com.example.musicplayerapp.domain.Song
import com.example.musicplayerapp.ui.GraphViewModel
import com.example.musicplayerapp.ui.SongViewAdapter
import com.example.musicplayerapp.ui.player.PlayerViewModel
import com.example.musicplayerapp.util.Constant
import com.example.musicplayerapp.util.Graph
import kotlinx.coroutines.launch

class PlaylistFragment : Fragment() {

    private lateinit var binding: FragmentPlaylistBinding
    private val graphViewModel: GraphViewModel by activityViewModels()
    private val playerViewModel: PlayerViewModel by activityViewModels()
    private val playlistViewModel: PlaylistViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaylistBinding.inflate(inflater, container, false)

        binding.btnHomePlaylist.setOnClickListener {
            graphViewModel.loadState(Graph.HOME)
        }
        binding.btnFavouritesPlaylist.setOnClickListener {
            graphViewModel.loadState(Graph.FAVOURITE)
        }
        binding.btnPlayerPlaylist.setOnClickListener {
            graphViewModel.loadState(Graph.PLAYER)
        }
        binding.btnBack.setOnClickListener {
            graphViewModel.loadState(Graph.HOME)
        }

        lifecycleScope.launch {
            playlistViewModel.statePlaylist.collect {
                if (it != null) {
                    binding.tvTitlePlaylist.setText(it)
                }
            }
        }
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvPlaylist.layoutManager = layoutManager
        binding.rvPlaylist.adapter = SongViewAdapter(Constant.firstPlaylist, ::onClick)
        return binding.root
    }

    private fun onClick(song: Song) {
        playerViewModel.loadState(song)
        graphViewModel.loadState(Graph.PLAYER)
    }
}