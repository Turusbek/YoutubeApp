package com.example.youtubeapp.data.remote

import com.example.youtubeapp.BuildConfig
import com.example.youtubeapp.model.Playlist
import com.example.youtubeapp.ui.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlayList(
        @Query("part") part: String = Constant.PART,
        @Query("channelId") channelId: String = Constant.CHANNEL_ID,
        @Query("maxResults") max: String = Constant.MAX_RESULTS,
        @Query("key") key: String = BuildConfig.API_KEY
    ): Call<Playlist>
}