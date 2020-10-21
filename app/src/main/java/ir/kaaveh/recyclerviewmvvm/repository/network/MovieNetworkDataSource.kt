package ir.kaaveh.recyclerviewmvvm.repository.network

import ir.kaaveh.recyclerviewmvvm.model.Movie
import ir.kaaveh.recyclerviewmvvm.model.MoviesResponse
import retrofit2.Response
import java.io.IOException

class MovieNetworkDataSource {

    suspend fun fetchMovies(movieName: String): List<Movie>? {
        var response: Response<MoviesResponse>? = null
        var movies: List<Movie>? = null

        try {
            response = MyAPI().getMovies(movieName)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        response?.let {
            if (response.isSuccessful) {
                movies = response.body()?.movieList
            }
        }
        return movies
    }
}