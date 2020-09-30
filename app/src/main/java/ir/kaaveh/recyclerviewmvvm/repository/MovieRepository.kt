package ir.kaaveh.recyclerviewmvvm.repository

import ir.kaaveh.recyclerviewmvvm.repository.database.MovieDatabase
import ir.kaaveh.recyclerviewmvvm.repository.network.MovieNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieRepository(
    movieNetworkDataSource: MovieNetworkDataSource,
    movieDatabase: MovieDatabase
) {
    var movies = movieDatabase.movieDatabaseDao.getAllMovies()

    init {
        GlobalScope.launch(Dispatchers.IO) {
            movieNetworkDataSource.fetchMovies()
        }
        movieNetworkDataSource.downloadedMovies.observeForever {
            GlobalScope.launch(Dispatchers.IO) {
                movieDatabase.movieDatabaseDao.insert(it)
            }
        }
    }
}