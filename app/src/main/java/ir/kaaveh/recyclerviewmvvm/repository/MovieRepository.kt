package ir.kaaveh.recyclerviewmvvm.repository

import android.util.Log
import ir.kaaveh.recyclerviewmvvm.model.MoviesResponse
import ir.kaaveh.recyclerviewmvvm.network.MyAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun getMovies(searchMovie: String = "batman"): MoviesResponse? {
    var response: Response<MoviesResponse>
    withContext(Dispatchers.IO) {
        response = MyAPI().getMovies(s = searchMovie)
        if (response.isSuccessful)
            Log.e("MovieViewModel", "response.isSuccessful is true")
    }
    return response.body()
}