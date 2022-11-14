package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasourceImpl

import com.blogspot.hellosrinath.mvvm_tmdb.data.db.TvShowDao
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShow
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShowList
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowFromDb(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowToDb(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShow)
        }
    }

    override suspend fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}