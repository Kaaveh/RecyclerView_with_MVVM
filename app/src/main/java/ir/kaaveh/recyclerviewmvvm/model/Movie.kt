package ir.kaaveh.recyclerviewmvvm.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movies_table")
@Parcelize
data class Movie(
    @SerializedName("Title")
    val title: String,

    @SerializedName("Year")
    val year: String,

    @PrimaryKey(autoGenerate = false)
    val imdbID: String,

    @SerializedName("Type")
    val type: String,

    @SerializedName("Poster")
    val poster: String
) : Parcelable