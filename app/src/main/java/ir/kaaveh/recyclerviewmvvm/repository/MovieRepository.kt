package ir.kaaveh.recyclerviewmvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.kaaveh.recyclerviewmvvm.model.Movie
import ir.kaaveh.recyclerviewmvvm.repository.network.MovieNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieRepository(movieNetworkDataSource: MovieNetworkDataSource) {
    private var _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    init {
        GlobalScope.launch(Dispatchers.IO) {
            movieNetworkDataSource.fetchMovies()
        }
        movieNetworkDataSource.downloadedMovies.observeForever {
            _movies.postValue(it)
        }
    }
}