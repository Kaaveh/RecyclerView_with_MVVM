package ir.kaaveh.recyclerviewmvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import ir.kaaveh.recyclerviewmvvm.R
import ir.kaaveh.recyclerviewmvvm.adapter.MovieAdapter
import ir.kaaveh.recyclerviewmvvm.adapter.MovieListener
import ir.kaaveh.recyclerviewmvvm.databinding.FragmentMainBinding
import ir.kaaveh.recyclerviewmvvm.viewmodel.MovieViewModel


class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        val movieViewModel: MovieViewModel by viewModels()

        val movieAdapter = MovieAdapter(MovieListener { movie ->
            movieViewModel.onMovieClicked(movie)
        }
        )
        binding.movieRecyclerview.adapter = movieAdapter

        movieViewModel.navigateToMovieDetail.observe(viewLifecycleOwner, Observer { movie ->
            movie?.let {
                this.findNavController().navigate(MainFragmentDirections
                    .actionMainFragmentToDetailFragment(movie))
                movieViewModel.onMovieDetailNavigated()
            }
        })
        movieViewModel.movies.observe(viewLifecycleOwner, {
            movieAdapter.movies = it
            binding.groupLoading.visibility = View.GONE
        })

        return binding.root
    }
}