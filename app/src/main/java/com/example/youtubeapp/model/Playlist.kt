package com.example.youtubeapp.model

data class Playlist(
    var etag: String?, // v8MclosYyUUSN2Iq2JNsdkQ865g
    var items: List<Item>,
    var kind: String?, // youtube#playlistListResponse
    var pageInfo: PageInfo?
)