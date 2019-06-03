package com.example.parcial1pdm.repository

import androidx.lifecycle.LiveData
import com.example.parcial1pdm.database.daos.MatchDao
import com.example.parcial1pdm.database.entities.Match

class MatchRoomRepository(private val matchDao: MatchDao){
    val allData: LiveData<List<Match>> = matchDao.getAll()


    suspend fun insert(match: Match){
        matchDao.insert(match)
    }
}