package com.example.myapplication3.dogapi.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication3.dogapi.model.DogImageRoom

@Dao
interface DogImageDao {
    @Query("SELECT * FROM chuck_norris_quote")
    fun selectAll() : LiveData<List<DogImageRoom>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(DogImageRoom: DogImageRoom)


    @Query("DELETE FROM chuck_norris_quote")
    fun deleteAll()
}