package ir.kaaveh.recyclerviewmvvm.viewmodel

import android.util.Log
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
        Log.e("MovieViewModel", "init started.")
        viewModelScope.launch {
            Log.e("MovieViewModel", "Coroutine started.")
            _movies.value = getMovies()
            Log.e("MovieViewModel", "Coroutine finished.")
            Log.e("MovieViewModel", _movies.toString())
        }
    }

    val movies: LiveData<List<Movie>>
        get() = _movies
}