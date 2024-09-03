package com.petros.efthymiou.dailypulse.topheadlines

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class HeadLinesService(private val httpClient: HttpClient) {
    private val country = "us"
    private val domain = "techcrunch.com,thenextweb.com"
    private val apiKey = "2d1e3c95b64e4bc59f18a6accce6faf1"
    suspend fun fetchHeadLines(): List<HeadLineRaw> {
        val response: HeadLinesResponse =
            //httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$domain&apiKey=$apiKey")
            httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&apiKey=$apiKey")
                .body()
        return response.articles
    }
}