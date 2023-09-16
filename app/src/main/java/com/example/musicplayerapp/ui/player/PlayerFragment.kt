package com.example.musicplayerapp.ui.player

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.musicplayerapp.R
import com.example.musicplayerapp.databinding.FragmentPlayerBinding
import com.example.musicplayerapp.ui.GraphViewModel
import com.example.musicplayerapp.util.Constant
import com.example.musicplayerapp.util.Graph
import kotlinx.coroutines.launch

class PlayerFragment : Fragment() {

    private lateinit var binding: FragmentPlayerBinding
    private val graphViewModel: GraphViewModel by activityViewModels()
    private val playerViewModel: PlayerViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerBinding.inflate(inflater, container, false)
        checkFavourite()
        binding.btnFavouritePlayer.setOnClickListener {
            graphViewModel.loadState(Graph.FAVOURITE)
        }
        binding.btnHomePlayer.setOnClickListener {
            graphViewModel.loadState(Graph.HOME)
        }

        lifecycleScope.launch {
            playerViewModel.statePlayer.collect {
                if (it != null) {
                    binding.tvTitlePlayer.setText(it.title)
                    binding.tvAuthorPlayer.setText(it.author)
                    binding.ivSong.setImageResource(it.image)
                    for (i in 2 downTo 0)
                        Constant.recentlyList[i + 1] = Constant.recentlyList[i]
                    Constant.recentlyList[0] = it
                }
            }
        }

        lifecycleScope.launch {
            playerViewModel.statePlayerPlay.collect {
                when (it) {
                    true -> {
                        binding.tvPlayStop.setText(R.string.pause)
                    }

                    false -> {
                        binding.tvPlayStop.setText(R.string.play)
                    }
                }
            }
        }
        binding.btnPlay.setOnClickListener {
            playerViewModel.loadStatePlay(!playerViewModel.statePlayerPlay.value)
        }
        binding.btnFavourite.setOnClickListener {
            if (checkFavourite()) {
                Constant.favouriteList.remove(playerViewModel.statePlayer.value)
                checkFavourite()
            } else {
                Constant.favouriteList.add(playerViewModel.statePlayer.value!!)
                checkFavourite()
            }
            Log.d("test", Constant.favouriteList.size.toString())
        }
        return binding.root
    }

    private fun checkFavourite(): Boolean {
        binding.ivHeart.setImageResource(R.drawable.icon_button_heart_false)
        for (i in Constant.favouriteList)
            if (i == playerViewModel.statePlayer.value) {
                binding.ivHeart.setImageResource(R.drawable.icon_button_heart_true)
                return true
            }
        return false
    }

}