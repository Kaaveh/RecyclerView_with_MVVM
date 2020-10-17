package ir.kaaveh.recyclerviewmvvm.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.kaaveh.recyclerviewmvvm.repository.database.MovieDatabase
import ir.kaaveh.recyclerviewmvvm.repository.network.MovieNetworkDataSource
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = MovieDatabase.getInstance(context)

    @Singleton
    @Provides
    fun provideMovieNetworkDataSource() = MovieNetworkDataSource()
}