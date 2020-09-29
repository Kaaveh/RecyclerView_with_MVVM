package ir.kaaveh.recyclerviewmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.kaaveh.recyclerviewmvvm.repository.MovieRepository

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory(private val repository: MovieRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repository)
    }
}