package ir.kaaveh.recyclerviewmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.kaaveh.recyclerviewmvvm.model.Movie
import ir.kaaveh.recyclerviewmvvm.repository.getMovies
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private var _movies = MutableLiveData<List<Movie>>()

    init {
        viewModelScope.launch {
            _movies.value = getMovies()?.movieList
        }
    }

    val movies: LiveData<List<Movie>>
        get() = _movies
}