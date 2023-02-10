package com.example.youtubeapp.model

import com.example.youtubeapp.data.remote.network.Resource

data class Snippet(
    var channelId: String?, // UCUXqcY7bSoBOm2Ymx3QKpMQ
    var channelTitle: String?, // INSTASAMKA
    var description: String?,
    var localized: Localized?,
    var publishedAt: String?, // 2022-08-15T19:05:23Z
    var thumbnails: Thumbnails?,
    val resourceId: ResourceId?,
    var title: String? // Shorts - INSTASAMKA
)

data class ResourceId(
    var kind: String?,
    var videoId: String?
)
