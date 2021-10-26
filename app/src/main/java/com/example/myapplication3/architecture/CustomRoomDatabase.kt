package com.example.myapplication3.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication3.dogapi.dao.DogImageDao
import com.example.myapplication3.dogapi.model.DogImageRoom

@Database(
    entities = [
        DogImageRoom::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun DogImageDao(): DogImageDao

}
