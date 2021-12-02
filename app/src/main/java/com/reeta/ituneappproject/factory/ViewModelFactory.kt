package com.reeta.ituneappproject.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reeta.ituneappproject.response.Repository
import com.reeta.ituneappproject.roomdatabase.SongDao
import com.reeta.ituneappproject.view.SongViewModel

class ViewModelFactory(var artice:String) :ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SongViewModel(artice) as T
    }


}