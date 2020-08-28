package ir.kaaveh.recyclerviewmvvm.network

import ir.kaaveh.recyclerviewmvvm.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyAPI {

    @GET("recyclerview/movies")
    suspend fun getMovies(): Response<List<Movie>>

    companion object {
        operator fun invoke(): MyAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.simplifiedcoding.in/course-apis/")
                .build()
                .create(MyAPI::class.java)
        }
    }
}