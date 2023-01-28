package com.example.youtubeapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.youtubeapp.model.Playlist

@Dao
interface PlaylistDao {

    @Insert
    fun insert(playlist: Playlist)

    @Query("SELECT * FROM playlist")
    fun getPlaylist(): Playlist

}