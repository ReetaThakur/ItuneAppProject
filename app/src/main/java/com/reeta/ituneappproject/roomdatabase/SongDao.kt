package com.reeta.ituneappproject.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SongDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSongs(song:ArrayList<Song>)

    @Query("select * from songsDetails")
    fun getSongs():LiveData<List<Song>>
}