package com.petros.efthymiou.dailypulse.di

import com.petros.efthymiou.dailypulse.articles.di.articlesModule
import com.petros.efthymiou.dailypulse.network.di.networkModule
import com.petros.efthymiou.dailypulse.topheadlines.di.headLinesModule

val sharedModules = listOf(articlesModule, networkModule, headLinesModule)