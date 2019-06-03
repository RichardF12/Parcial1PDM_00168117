package com.example.parcial1pdm.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName  = "match_table")
data class Match (
        @ColumnInfo(name = "team1") val team1 : String,
        @ColumnInfo(name = "team2") val team2: String,
        @ColumnInfo(name = "score1") val points1 : Int,
        @ColumnInfo(name = "score2") val points2 : Int,
        @ColumnInfo(name = "winner") val winner: String,
        @ColumnInfo(name = "date") val date: String,
        @ColumnInfo(name = "time") val time: String
){@PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "id")var id : Long = 0}