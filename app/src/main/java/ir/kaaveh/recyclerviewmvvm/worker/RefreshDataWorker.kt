package ir.kaaveh.recyclerviewmvvm.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import ir.kaaveh.recyclerviewmvvm.repository.MovieRepository
import ir.kaaveh.recyclerviewmvvm.repository.database.MovieDatabase
import ir.kaaveh.recyclerviewmvvm.repository.network.MovieNetworkDataSource
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {
    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val dataSource = MovieDatabase.getInstance(applicationContext)

        return try {
            val repository = MovieRepository(MovieNetworkDataSource(), dataSource)
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

}