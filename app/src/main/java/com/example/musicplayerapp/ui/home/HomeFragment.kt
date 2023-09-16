package com.example.musicplayerapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.musicplayerapp.R
import com.example.musicplayerapp.databinding.FragmentHomeBinding
import com.example.musicplayerapp.ui.GraphViewModel
import com.example.musicplayerapp.ui.player.PlayerViewModel
import com.example.musicplayerapp.ui.playlist.PlaylistViewModel
import com.example.musicplayerapp.util.Constant
import com.example.musicplayerapp.util.Graph

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val graphViewModel: GraphViewModel by activityViewModels()
    private val playerViewModel: PlayerViewModel by activityViewModels()
    private val playlistViewModel: PlaylistViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.ivImageRecently1.setImageResource(Constant.recentlyList[0].image)
        binding.ivImageRecently2.setImageResource(Constant.recentlyList[1].image)
        binding.ivImageRecently3.setImageResource(Constant.recentlyList[2].image)
        binding.ivImageRecently4.setImageResource(Constant.recentlyList[3].image)
        binding.tvAuthorRecently1.setText(Constant.recentlyList[0].author)
        binding.tvAuthorRecently2.setText(Constant.recentlyList[1].author)
        binding.tvAuthorRecently3.setText(Constant.recentlyList[2].author)
        binding.tvAuthorRecently4.setText(Constant.recentlyList[3].author)
        binding.tvTitleRecently1.setText(Constant.recentlyList[0].title)
        binding.tvTitleRecently2.setText(Constant.recentlyList[1].title)
        binding.tvTitleRecently3.setText(Constant.recentlyList[2].title)
        binding.tvTitleRecently4.setText(Constant.recentlyList[3].title)

        binding.btnHeartHome.setOnClickListener {
            graphViewModel.loadState(Graph.FAVOURITE)
        }
        binding.btnPlayerHome.setOnClickListener {
            graphViewModel.loadState(Graph.PLAYER)
        }
        binding.btnRecently1.setOnClickListener {
            playerViewModel.loadState(Constant.recentlyList[0])
            graphViewModel.loadState(Graph.PLAYER)
        }
        binding.btnRecently2.setOnClickListener {
            playerViewModel.loadState(Constant.recentlyList[1])
            graphViewModel.loadState(Graph.PLAYER)
        }
        binding.btnRecently3.setOnClickListener {
            playerViewModel.loadState(Constant.recentlyList[2])
            graphViewModel.loadState(Graph.PLAYER)
        }
        binding.btnRecently4.setOnClickListener {
            playerViewModel.loadState(Constant.recentlyList[3])
            graphViewModel.loadState(Graph.PLAYER)
        }
        binding.btnPlaylist1.setOnClickListener {
            playlistViewModel.loadState(R.string.twilight_sonata)
            graphViewModel.loadState(Graph.PLAYLIST)
        }
        binding.btnPlaylist2.setOnClickListener {
            playlistViewModel.loadState(R.string.cosmic_echoes)
            graphViewModel.loadState(Graph.PLAYLIST)
        }
        binding.btnPlaylist3.setOnClickListener {
            playlistViewModel.loadState(R.string.crimson_horizon)
            graphViewModel.loadState(Graph.PLAYLIST)
        }

        return binding.root
    }


}