package ir.kaaveh.recyclerviewmvvm.repository

import ir.kaaveh.recyclerviewmvvm.model.Movie

fun getMoviesList(): List<Movie> =
    arrayListOf(
        Movie("Interstellar", 8.9),
        Movie("WestWorld", 10.0),
        Movie("Dark", 8.5)
    )