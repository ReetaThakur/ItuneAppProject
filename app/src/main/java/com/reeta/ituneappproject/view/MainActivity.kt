package com.reeta.ituneappproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.reeta.ituneappproject.R
import com.reeta.ituneappproject.factory.ViewModelFactory
import com.reeta.ituneappproject.response.Repository
import com.reeta.ituneappproject.response.Result
import com.reeta.ituneappproject.roomdatabase.Song
import com.reeta.ituneappproject.roomdatabase.SongDao
import com.reeta.ituneappproject.roomdatabase.SongRoomdatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: SongViewModel
    lateinit var songAdapter: SongAdapter
    private var songList =ArrayList<Result>()
     lateinit var searchArtice:EditText
     lateinit var repository: Repository
     lateinit var arctice:String
//      private var list= mutableListOf<Song>()
//    lateinit var roomDb:SongRoomdatabase
//    lateinit var songDao: SongDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchArtice=findViewById(R.id.searchView)
//        roomDb= SongRoomdatabase.getDatabaseObject(this)
//        songDao=roomDb.getSongDao()


        btnSearch.setOnClickListener {
           arctice=searchArtice.text.toString()
            var viewModelFactory=ViewModelFactory(arctice)
            viewModel=ViewModelProvider(this,viewModelFactory).get(SongViewModel::class.java)
            repository= Repository(arctice)
            setData()
       }

      //  setDataFromDB()


    }

//    private fun setDataFromDB() {
//        viewModel.getSongsFromDB().observe(this,{
//            list.clear()
//            list.addAll(it)
//            list.reverse()
//            songAdapter.notifyDataSetChanged()
//        })
//    }

    private fun setData() {

        viewModel.callApi()
        viewModel.liveData.observe(this,{
            it.let {
                when(it){
                    is MainUiModel.onSuccess ->{
                        songList=it.responseDTO.results as ArrayList<Result>
                        setRecyclerView()
                    }

                    is MainUiModel.onFailure ->{
                        Toast.makeText(this,it.error,Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })
    }

    fun setRecyclerView(){
        songAdapter= SongAdapter(songList)
        var gridLayoutManager=GridLayoutManager(this,2)
        recyclerView.apply {
            adapter=songAdapter
            layoutManager=gridLayoutManager
        }
    }
}