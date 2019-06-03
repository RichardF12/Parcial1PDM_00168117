package com.example.parcial1pdm.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial1pdm.database.entities.Match

@Dao
interface MatchDao {
    @Query("SELECT * FROM match_table ORDER BY date ASC")
    fun getAll() : LiveData<List<Match>>

    @Query("DELETE FROM match_table")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(matches : Match)
}