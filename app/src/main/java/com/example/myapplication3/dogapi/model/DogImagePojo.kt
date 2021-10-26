package com.example.myapplication3.dogapi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Object use for Ui */
data class DogImageUi(
    val quote: String,
    val typeJoke: String,
    val firstLine : String,
    val secondLine : String,
    val safe : String
)

/** Object use for room */
@Entity(tableName = "chuck_norris_quote")
data class DogImageRoom(
    @ColumnInfo(name = "quote_text")
    val quote: String,
    val typeJoke: String,
    val firstLine : String,
    val secondLine : String,
    val safe : String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

/** Object use for retrofit */
data class DogImageRetrofit(
    @Expose
    @SerializedName("category")
    val quote: String,
    @Expose
    @SerializedName("type")
    val typeJoke: String,
    @Expose
    @SerializedName("setup")
    val firstLine: String,
    @Expose
    @SerializedName("delivery")
    val secondLine: String,
    @Expose
    @SerializedName("safe")
    val safe: String
)
