package com.reeta.ituneappproject.response

import android.widget.TextView
import androidx.lifecycle.LiveData
import com.reeta.ituneappproject.roomdatabase.Song
import com.reeta.ituneappproject.roomdatabase.SongDao

class Repository(var artice: String) {

    val entity="song"
    lateinit var songDao: SongDao

   suspend fun getSongs():ResponseDTO{
        return Network.getApiService().getInstance(artice,entity)
   }

    private fun saveToDB(responseDTO: ResponseDTO){
        val listOfSongs =ArrayList<Song>()
        responseDTO.results.forEach {
            val newSong=Song(it.trackName,it.artistName)
            listOfSongs.add(newSong)
        }
        songDao.addSongs(listOfSongs)
    }

    fun getAllSongs():LiveData<List<Song>>{
        return songDao.getSongs()
    }

}