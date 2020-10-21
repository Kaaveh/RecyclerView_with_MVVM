package ir.kaaveh.recyclerviewmvvm.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.kaaveh.recyclerviewmvvm.model.Movie
import ir.kaaveh.recyclerviewmvvm.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel @ViewModelInject constructor(
    movieRepository: MovieRepository
) : ViewModel() {

    val movies = movieRepository.movies

    private var _darkMode = MutableLiveData<Boolean>()
    val darkMode: LiveData<Boolean>
        get() = _darkMode

    init {
        viewModelScope.launch {
            movieRepository.refreshMovies("batman")
        }
        _darkMode.value = false
    }

    fun darkModeChange() {
        _darkMode.value = _darkMode.value != true
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