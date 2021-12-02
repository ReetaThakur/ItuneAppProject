package com.reeta.ituneappproject.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Song::class],version = 1)

abstract class SongRoomdatabase:RoomDatabase() {

    abstract fun getSongDao() : SongDao

    companion object{
        private var INSTANCE: SongRoomdatabase ? =null

        fun getDatabaseObject(context: Context) :SongRoomdatabase{

            if (INSTANCE==null){
                val builder = Room.databaseBuilder(context.applicationContext,SongRoomdatabase::class.java,"song_db")
                builder.fallbackToDestructiveMigration()
                INSTANCE=builder.build()
                return INSTANCE!!
            }else{
                return INSTANCE!!
            }
        }
    }

}