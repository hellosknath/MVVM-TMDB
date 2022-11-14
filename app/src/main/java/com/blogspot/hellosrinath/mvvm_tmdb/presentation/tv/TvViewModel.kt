package com.blogspot.hellosrinath.mvvm_tmdb.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.GetTvShowUseCase
import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.UpdateTvShowUseCase

class TvViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {

    fun getTvShow() = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList = updateTvShowUseCase.execute()
        emit(tvShowList)
    }

}