package ir.kaaveh.recyclerviewmvvm.network

import ir.kaaveh.recyclerviewmvvm.model.MoviesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MyAPI {
//    val API_KEY
//        get() = "899f27bf"

    @GET("http://www.omdbapi.com/")
    suspend fun getMovies(
        @Query("apikey") apikey: String,
        @Query("s") s: String
    ): Response<MoviesResponse>

    companion object {
        operator fun invoke(): MyAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.omdbapi.com/")
                .build()
                .create(MyAPI::class.java)
        }
    }
}