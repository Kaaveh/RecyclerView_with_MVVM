package ir.kaaveh.recyclerviewmvvm.model

data class MoviesResponse (
    val Search: List<Movie>,
    val totalResults: String,
    val Response: String
)