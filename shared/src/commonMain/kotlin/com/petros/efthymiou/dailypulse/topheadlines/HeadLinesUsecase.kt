package com.petros.efthymiou.dailypulse.topheadlines

class HeadLinesUsecase(private val headLinesService: HeadLinesService) {

    suspend fun fetchHeadLines() = headLinesService.fetchHeadLines()

}