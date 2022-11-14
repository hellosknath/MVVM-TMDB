package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow

import android.util.Log
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.MovieList
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShow
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShowList
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.TvShowsRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowFromCashe()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newTvShowList = getTvShowsFromAPI()
        tvShowLocalDataSource.deleteAll()
        tvShowLocalDataSource.saveTvShowToDb(newTvShowList)
        tvShowCacheDataSource.saveTvShowToCache(newTvShowList)
        return newTvShowList
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvshowList: List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemoteDataSource.getShows()
            val body: TvShowList? = response.body()
            if (body != null) {
                tvshowList = body.tvshows
            }
        } catch (e: Exception) {
            Log.i(Companion.TAG, "getTvShowsFromAPI: ${e.message.toString()}")
        }
        return tvshowList
    }

    suspend fun getTvShowFromDb(): List<TvShow> {
        lateinit var tvshowList: List<TvShow>
        try {
            tvshowList = tvShowLocalDataSource.getTvShowFromDb()
        } catch (e: Exception) {
            Log.i(Companion.TAG, "getTvShowFromDb: ${e.message.toString()}")
        }
        if (tvshowList.size > 0) {
            return tvshowList
        } else {
            tvshowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowToDb(tvshowList)
        }
        return tvshowList
    }

    suspend fun getTvShowFromCashe(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (e: Exception) {
            Log.i(Companion.TAG, "getTvShowFromCashe: ${e.message.toString()}")
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromDb()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }

    companion object {
        private const val TAG = "TvShowRepositoryImpl"
    }
}