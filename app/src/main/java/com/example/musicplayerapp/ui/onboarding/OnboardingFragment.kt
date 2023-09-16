package com.example.musicplayerapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.musicplayerapp.databinding.FragmentOnboardingBinding
import com.example.musicplayerapp.ui.GraphViewModel
import com.example.musicplayerapp.util.Graph

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    private val graphViewModel: GraphViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        binding.btnStart.setOnClickListener {
            graphViewModel.loadState(Graph.HOME)
        }
        return binding.root
    }

}