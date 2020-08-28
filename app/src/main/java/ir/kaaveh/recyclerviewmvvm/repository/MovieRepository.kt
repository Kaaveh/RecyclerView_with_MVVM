package ir.kaaveh.recyclerviewmvvm.repository

import android.util.Log
import ir.kaaveh.recyclerviewmvvm.model.Movie
import ir.kaaveh.recyclerviewmvvm.network.MyAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun getMovies(): List<Movie>? {
    var response: Response<List<Movie>>
    withContext(Dispatchers.IO) {
        response = MyAPI().getMovies()
        if (response.isSuccessful)
            Log.e("MovieViewModel", "response.isSuccessful is true")
    }
    return response.body()
}