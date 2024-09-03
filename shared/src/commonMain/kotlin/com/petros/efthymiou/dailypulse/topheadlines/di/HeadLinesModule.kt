package com.petros.efthymiou.dailypulse.topheadlines.di

import com.petros.efthymiou.dailypulse.topheadlines.HeadLinesService
import com.petros.efthymiou.dailypulse.topheadlines.HeadLinesUsecase
import com.petros.efthymiou.dailypulse.topheadlines.HeadLinesViewModel
import org.koin.dsl.module

val headLinesModule = module {
    single<HeadLinesService> { HeadLinesService(get()) }
    single<HeadLinesUsecase> { HeadLinesUsecase(get()) }
    single<HeadLinesViewModel> { HeadLinesViewModel(get()) }
}