package com.reeta.ituneappproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reeta.ituneappproject.R
import com.reeta.ituneappproject.response.Result

class SongAdapter(val list:ArrayList<Result>):RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.song_layout,parent,false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        var songList =list[position]
        holder.setData(songList)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class SongViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var songImage:ImageView=itemView.findViewById(R.id.songImage)
        var songName:TextView=itemView.findViewById(R.id.tvSongName)
        var songArtice:TextView=itemView.findViewById(R.id.tvArticName)
        fun setData(result: Result){
            Glide.with(songImage).load(result.artworkUrl100).into(songImage)
            songName.text=result.trackName
            songArtice.text=result.artistName
        }

    }
}