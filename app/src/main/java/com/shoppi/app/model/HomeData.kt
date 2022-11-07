package com.shoppi.app.model

import com.google.gson.annotations.SerializedName
import com.shoppi.app.model.Banner

data class HomeData (
    val title: Title,
    @SerializedName("top_banners") val topBanners: List<Banner>
)
