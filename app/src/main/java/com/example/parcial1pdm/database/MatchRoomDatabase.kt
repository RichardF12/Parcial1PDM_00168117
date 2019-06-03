package com.example.parcial1pdm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial1pdm.database.daos.MatchDao
import com.example.parcial1pdm.database.entities.Match

@Database(entities = [Match::class], version = 2, exportSchema = false)
abstract class MatchRoomDatabase : RoomDatabase() {

    abstract fun matchesDao(): MatchDao

    companion object {
        @Volatile
        private var INSTANCE: MatchRoomDatabase? = null

        fun getDatabase(
            context: Context
        ): MatchRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MatchRoomDatabase::class.java,
                    "matches_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}