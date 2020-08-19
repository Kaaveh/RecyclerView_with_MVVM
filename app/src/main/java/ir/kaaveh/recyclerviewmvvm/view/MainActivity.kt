package ir.kaaveh.recyclerviewmvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import ir.kaaveh.recyclerviewmvvm.R
import ir.kaaveh.recyclerviewmvvm.adapter.MovieAdapter
import ir.kaaveh.recyclerviewmvvm.databinding.ActivityMainBinding
import ir.kaaveh.recyclerviewmvvm.model.Movie
import ir.kaaveh.recyclerviewmvvm.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val movieViewModel: MovieViewModel by viewModels()

        movieViewModel.movies.observe(this, Observer<List<Movie>> { movies ->
            binding.movieRecyclerview.also {
                it.setHasFixedSize(true)
                it.adapter = MovieAdapter(movies)
            }
        })
    }
}