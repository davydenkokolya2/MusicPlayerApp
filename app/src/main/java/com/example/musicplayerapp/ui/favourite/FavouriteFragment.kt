package com.example.musicplayerapp.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayerapp.databinding.FragmentFavouriteBinding
import com.example.musicplayerapp.domain.Song
import com.example.musicplayerapp.ui.GraphViewModel
import com.example.musicplayerapp.ui.SongViewAdapter
import com.example.musicplayerapp.ui.player.PlayerViewModel
import com.example.musicplayerapp.util.Constant
import com.example.musicplayerapp.util.Graph

class FavouriteFragment : Fragment() {

    private lateinit var binding: FragmentFavouriteBinding
    private val graphViewModel: GraphViewModel by activityViewModels()
    private val playerViewModel: PlayerViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        binding.btnHomeFavourite.setOnClickListener {
            graphViewModel.loadState(Graph.HOME)
        }
        binding.btnPlayerFavourite.setOnClickListener {
            graphViewModel.loadState(Graph.PLAYER)
        }

        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvFavourite.layoutManager = layoutManager
        binding.rvFavourite.adapter = SongViewAdapter(Constant.favouriteList, ::onClick)

        return binding.root
    }
    private fun onClick(song: Song) {
        playerViewModel.loadState(song)
        graphViewModel.loadState(Graph.PLAYER)
    }
}