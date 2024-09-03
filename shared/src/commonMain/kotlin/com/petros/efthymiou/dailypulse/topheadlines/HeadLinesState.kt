package com.petros.efthymiou.dailypulse.topheadlines

data class HeadLinesState(
    val articles: List<HeadLineRaw> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)