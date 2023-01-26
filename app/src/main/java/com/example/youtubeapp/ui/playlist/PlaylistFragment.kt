package com.example.youtubeapp.ui.playlist


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.youtubeapp.R
import com.example.youtubeapp.base.BaseFragment
import com.example.youtubeapp.databinding.FragmentPlaylistBinding
import com.example.youtubeapp.ui.internet.CheckInternet


class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {
    private lateinit var adapter: PlaylistAdapter
    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        adapter = PlaylistAdapter()
        binding.rvPlaylist.adapter = adapter
        val checkInternet = CheckInternet(requireContext())
        checkInternet.observe(this) { isConnected ->
            if (!isConnected) {
                findNavController().navigate(R.id.errorFragment)
            }
        }
    }

    override fun initViewModel() {
        viewModel.getPlaylist().observe(viewLifecycleOwner) {
            Log.e("ololo", "initViewModel:${it}")
            adapter.setList(it.items)
        }
    }
}