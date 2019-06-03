package com.example.parcial1pdm.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.parcial1pdm.database.MatchRoomDatabase
import com.example.parcial1pdm.database.entities.Match
import com.example.parcial1pdm.repository.MatchRoomRepository
import kotlinx.coroutines.launch

class MatchViewModel(application: Application) : AndroidViewModel(application){
    private val repository: MatchRoomRepository


    val allData: LiveData<List<Match>>

    init{
        val matchDao = MatchRoomDatabase.getDatabase(application).matchesDao()
        repository = MatchRoomRepository(matchDao)
        allData = repository.allData
    }

    fun insert(match: Match) = viewModelScope.launch {
        repository.insert(match)
    }

}