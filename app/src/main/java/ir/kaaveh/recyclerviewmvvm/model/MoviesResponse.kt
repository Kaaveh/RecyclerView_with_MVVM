package ir.kaaveh.recyclerviewmvvm.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse (
    @SerializedName("Search")
    val movieList: List<Movie>,
    val totalResults: String,
    val Response: String
)