package ir.kaaveh.recyclerviewmvvm.repository

import ir.kaaveh.recyclerviewmvvm.repository.database.MovieDatabase
import ir.kaaveh.recyclerviewmvvm.repository.network.MovieNetworkDataSource
import kotlinx.coroutines.*

class MovieRepository(
    movieNetworkDataSource: MovieNetworkDataSource,
    movieDatabase: MovieDatabase
) {
    val movies = movieDatabase.movieDatabaseDao.getAllMovies()
    private val job = Job()
    private val scope = CoroutineScope(job)

    init {
        scope.launch(Dispatchers.IO) {
            movieNetworkDataSource.fetchMovies()
        }
        movieNetworkDataSource.downloadedMovies.observeForever {
            scope.launch(Dispatchers.IO) {
                movieDatabase.movieDatabaseDao.insert(it)
            }
        }
    }
}