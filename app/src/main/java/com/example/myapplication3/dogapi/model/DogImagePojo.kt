package com.example.myapplication3.dogapi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Object use for Ui */
data class DogImageUi(
    val quote: String,
    val iconUrl: String
)

/** Object use for room */
@Entity(tableName = "chuck_norris_quote")
data class DogImageRoom(
    @ColumnInfo(name = "quote_text")
    val quote: String,


    @ColumnInfo(name = "quote_icon_url")
    val iconUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

/** Object use for retrofit */
data class DogImageRetrofit(
    @Expose
    @SerializedName("status")
    val quote: String,


    @Expose
    @SerializedName("message")
    val iconUrl: String
)
