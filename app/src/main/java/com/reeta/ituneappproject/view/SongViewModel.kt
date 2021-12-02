package com.reeta.ituneappproject.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reeta.ituneappproject.response.Repository
import com.reeta.ituneappproject.roomdatabase.Song
import com.reeta.ituneappproject.roomdatabase.SongDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongViewModel(var artice:String) : ViewModel() {

    private  var  repository=Repository(artice)
    private val mutableLivedata =MutableLiveData<MainUiModel>()
    val liveData : LiveData<MainUiModel> = mutableLivedata

    fun callApi() {
        CoroutineScope(Dispatchers.IO).launch {
            var responseDTO =repository.getSongs()
            if (responseDTO.results!=null){
                mutableLivedata.postValue(MainUiModel.onSuccess(responseDTO))
            }else{
                mutableLivedata.postValue(MainUiModel.onFailure("error"))
            }
        }
    }

    fun getSongsFromDB():LiveData<List<Song>>{
        return repository.getAllSongs()
    }
}