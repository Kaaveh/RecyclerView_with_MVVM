package ir.kaaveh.recyclerviewmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.kaaveh.recyclerviewmvvm.model.Movie
import ir.kaaveh.recyclerviewmvvm.repository.getMoviesList

class MovieViewModel : ViewModel() {

    private val _movies: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>().also {
            getMovies(it)
        }
    }

    init {
        Log.e("start", "start")
    }

    val movies: LiveData<List<Movie>>
        get() = _movies

    private fun getMovies(_movies: MutableLiveData<List<Movie>>) {
        _movies.value = getMoviesList()
    }
}