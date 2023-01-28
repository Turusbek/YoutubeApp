package com.example.youtubeapp.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.youtubeapp.R
import com.example.youtubeapp.base.BaseFragment
import com.example.youtubeapp.databinding.FragmentDetailsPlaylistBinding
import com.example.youtubeapp.ui.internet.CheckInternet
import com.example.youtubeapp.ui.playlist.PlaylistFragment

class PlaylistDetailsFragment : BaseFragment<FragmentDetailsPlaylistBinding,
        PlaylistDetailsViewModel>() {

    private lateinit var adapter: PlaylistDetailsAdapter

    override val viewModel: PlaylistDetailsViewModel by lazy {
        ViewModelProvider(this)[PlaylistDetailsViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsPlaylistBinding {
        return FragmentDetailsPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initViewModel() {
        val id = arguments?.getString(PlaylistFragment.PLAYLIST_KEY)
        val title = arguments?.getString(PlaylistFragment.PLAYLIST)
        viewModel.getPlaylistDetails(id.toString()).observe(viewLifecycleOwner) {
            adapter.getList(it.items)
            binding.decVideo.text = title.toString()

        }
    }

    override fun initView() {
        adapter = PlaylistDetailsAdapter()
        binding.recyclerView.adapter = adapter
        val checkInternet = CheckInternet(requireContext())
        checkInternet.observe(this) { isConnected ->
            if (!isConnected) {
                findNavController().navigate(R.id.errorFragment)
            }
        }
    }
}