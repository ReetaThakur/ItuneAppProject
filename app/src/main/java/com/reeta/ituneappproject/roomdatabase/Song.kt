package com.reeta.ituneappproject.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songsDetails")
data class Song(@ColumnInfo(name = "songName") var songName:String,
@ColumnInfo(name = "songArtice") var songArtice:String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id") var id:Int?=null
}