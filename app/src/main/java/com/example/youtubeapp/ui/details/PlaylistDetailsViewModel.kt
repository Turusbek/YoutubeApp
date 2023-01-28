package com.example.youtubeapp.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapp.base.BaseViewModel
import com.example.youtubeapp.data.remote.RetrofitClient
import com.example.youtubeapp.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistDetailsViewModel : BaseViewModel() {
    private val apiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylistDetails(playlistId: String): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()
        apiService.getPlayListDetails(playlistId = playlistId).enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("ololo", "onFailure: " + t.message)
            }
        })
        return data
    }
}