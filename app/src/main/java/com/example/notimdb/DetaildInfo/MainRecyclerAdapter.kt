package com.example.notimdb.DetaildInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notimdb.Data.response.Movies
import com.example.notimdb.R

class MainRecyclerAdapter(
    private val MovieList: List<Movies>
) : RecyclerView.Adapter<MainViewHolder>() {

    override fun getItemCount(): Int {
        return MovieList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_card, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setMovie(MovieList[position])
    }

}

