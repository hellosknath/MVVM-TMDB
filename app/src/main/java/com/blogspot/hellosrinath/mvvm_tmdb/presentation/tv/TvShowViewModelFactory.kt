package com.blogspot.hellosrinath.mvvm_tmdb.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.GetTvShowUseCase
import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}