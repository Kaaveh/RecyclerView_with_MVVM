package ir.kaaveh.recyclerviewmvvm.repository.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import ir.kaaveh.recyclerviewmvvm.getOrAwaitValue
import ir.kaaveh.recyclerviewmvvm.model.Movie
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class MovieDatabaseDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: MovieDatabase

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MovieDatabase::class.java
        ).allowMainThreadQueries()
            .build()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertMovie() = runBlockingTest {
        val movie = Movie("test", "2020", "123456", "Movie", "poster link")
        database.movieDatabaseDao.insert(listOf(movie))

        val movies = database.movieDatabaseDao.getAllMovies().getOrAwaitValue()

        assertThat(movies).contains(movie)
    }

    @Test
    fun clearDatabase() = runBlockingTest {
        val movie = Movie("test", "2020", "123456", "Movie", "poster link")
        database.movieDatabaseDao.insert(listOf(movie))
        database.movieDatabaseDao.clear()

        val movies = database.movieDatabaseDao.getAllMovies().getOrAwaitValue()
        assertThat(movies).isEmpty()
    }
}