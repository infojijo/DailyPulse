package com.petros.efthymiou.dailypulse.topheadlines

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeadLinesResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val results: Int,
    @SerialName("articles")
    val articles: List<HeadLineRaw>
)
