package com.petros.efthymiou.dailypulse.topheadlines

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeadLineRaw(
    @SerialName("author")
    val title: String? = "",
    @SerialName("title")
    val desc: String? = ""
)
