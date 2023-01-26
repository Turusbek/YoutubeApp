package com.example.youtubeapp.ui.playlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapp.data.remote.RetrofitClient
import com.example.youtubeapp.base.BaseViewModel
import com.example.youtubeapp.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    private val apiService = RetrofitClient.create()

    fun getPlaylist(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()
        apiService.getPlayList().enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
                Log.e("-----------", "${response.body()}")
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("ololo", "onFailure: " + t.message)
            }

        })
        return data
    }
}