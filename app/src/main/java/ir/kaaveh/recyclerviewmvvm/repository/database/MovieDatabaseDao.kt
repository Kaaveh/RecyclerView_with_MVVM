package ir.kaaveh.recyclerviewmvvm.repository.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.kaaveh.recyclerviewmvvm.model.Movie

@Dao
interface MovieDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: List<Movie>)

    @Query("SELECT * FROM movies_table")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("DELETE FROM movies_table")
    suspend fun clear()
}