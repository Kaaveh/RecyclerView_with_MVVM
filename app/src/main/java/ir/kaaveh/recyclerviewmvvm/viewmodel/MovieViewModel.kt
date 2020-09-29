package ir.kaaveh.recyclerviewmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.kaaveh.recyclerviewmvvm.model.Movie
import ir.kaaveh.recyclerviewmvvm.repository.MovieRepository

class MovieViewModel(movieRepository: MovieRepository) : ViewModel() {
    private var _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    init {
        movieRepository.movies.observeForever {
            _movies.postValue(it)
        }
    }

    //Navigate to detail
    private val _navigateToMovieDetail = MutableLiveData<Movie>()
    val navigateToMovieDetail
        get() = _navigateToMovieDetail

    fun onMovieClicked(movie: Movie) {
        _navigateToMovieDetail.value = movie
    }

    fun onMovieDetailNavigated() {
        _navigateToMovieDetail.value = null
    }
}