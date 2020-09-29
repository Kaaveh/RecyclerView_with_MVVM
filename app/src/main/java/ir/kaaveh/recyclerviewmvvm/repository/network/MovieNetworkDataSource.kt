package ir.kaaveh.recyclerviewmvvm.repository.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.kaaveh.recyclerviewmvvm.model.Movie
import java.io.IOException

class MovieNetworkDataSource {
    private val _downloadedMovies = MutableLiveData<List<Movie>>()
    val downloadedMovies: LiveData<List<Movie>>
        get() = _downloadedMovies

    suspend fun fetchMovies() {
        try {
            val fetchedMovies = MyAPI()
                .getMovies("batman")
            _downloadedMovies.postValue(fetchedMovies.movieList)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}