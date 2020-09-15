package ir.kaaveh.recyclerviewmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ir.kaaveh.recyclerviewmvvm.R
import ir.kaaveh.recyclerviewmvvm.databinding.ItemRecyclerviewMovieBinding
import ir.kaaveh.recyclerviewmvvm.model.Movie

class MovieAdapter(private val clickListener: MovieListener) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movies: List<Movie>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_recyclerview_movie,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = movies?.size ?: 0

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.movie = movies!![position]
        holder.binding.clickListener = clickListener
    }

    class MovieViewHolder(val binding: ItemRecyclerviewMovieBinding) :
        RecyclerView.ViewHolder(binding.root)
}

class MovieListener(val clickListener: (movie: Movie) -> Unit) {
    fun onClick(movie: Movie) = clickListener(movie)
}