package com.petros.efthymiou.dailypulse.topheadlines

import com.petros.efthymiou.dailypulse.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HeadLinesViewModel(private val headlinesUsecase: HeadLinesUsecase) : BaseViewModel() {
    private val _headLinesList: MutableStateFlow<HeadLinesState> =
        MutableStateFlow(HeadLinesState(loading = true))
    val headLinesList: StateFlow<HeadLinesState> get() = _headLinesList

    init {
        getHeadLines()
    }

    private fun getHeadLines() {
        scope.launch {
            _headLinesList.emit(HeadLinesState(headlinesUsecase.fetchHeadLines()))
        }
    }
}