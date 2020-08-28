package ir.kaaveh.recyclerviewmvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ir.kaaveh.recyclerviewmvvm.R
import ir.kaaveh.recyclerviewmvvm.adapter.MovieAdapter
import ir.kaaveh.recyclerviewmvvm.databinding.ActivityMainBinding
import ir.kaaveh.recyclerviewmvvm.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private val movieAdapter by lazy { MovieAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val movieViewModel: MovieViewModel by viewModels()

        binding.movieRecyclerview.adapter = movieAdapter

        movieViewModel.movies.observe(this, {
            movieAdapter.movies = it
        })
    }
}