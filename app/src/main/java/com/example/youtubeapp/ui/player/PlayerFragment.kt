package com.example.youtubeapp.ui.player

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.youtubeapp.base.BaseFragment
import com.example.youtubeapp.databinding.FragmentPlayerBinding
import com.example.youtubeapp.ui.details.PlaylistDetailsFragment
import com.example.youtubeapp.ui.details.PlaylistDetailsFragment.Companion.VIDEO_ID
import com.example.youtubeapp.utils.youtubeListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerFragment : BaseFragment<FragmentPlayerBinding, PlayerViewModel>() {
    override val viewModel: PlayerViewModel by viewModel()
    private var videoId = ""

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayerBinding {
        return FragmentPlayerBinding.inflate(inflater, container, false)
    }

    override fun initViewModel() {
        val title = arguments?.getString(PlaylistDetailsFragment.TITLE)
        binding.tvTitle.text = title.toString()

    }

    override fun initView() {
        videoId = arguments?.getString(VIDEO_ID, "").toString()
        lifecycle.addObserver(binding.youtubePlayerView)
        binding.youtubePlayerView.addYouTubePlayerListener(youtubeListener { youTubePlayer ->
            youTubePlayer.loadVideo(videoId, 0F)
        })
        fullScreen()
    }

    private fun fullScreen() {
        binding.btnFullScreen.setOnClickListener {
            if (binding.youtubePlayerView.isFullScreen()) {
                binding.youtubePlayerView.exitFullScreen()
            } else {
                binding.youtubePlayerView.enterFullScreen()
            }
        }
    }
}