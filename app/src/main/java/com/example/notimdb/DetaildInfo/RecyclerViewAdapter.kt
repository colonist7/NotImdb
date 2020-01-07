package com.example.notimdb.DetaildInfo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notimdb.Data.response.Cast
import com.example.notimdb.R

class RecyclerViewAdapter(
    private val CastList: List<Cast>
) : RecyclerView.Adapter<CastListViewHolder>() {

    override fun getItemCount(): Int {
        return CastList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return CastListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastListViewHolder, position: Int) {
        holder.setCast(CastList[position])
    }

}

