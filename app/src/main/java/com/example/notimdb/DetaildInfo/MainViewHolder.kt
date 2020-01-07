package com.example.notimdb.DetaildInfo

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notimdb.Data.response.Cast
import com.bumptech.glide.Glide
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.annotation.GlideModule
import com.example.notimdb.Data.response.Movies


@GlideModule
class MyAppGlideModule2 : AppGlideModule()// leave empty for now

class MainViewHolder (
    view: View
) : RecyclerView.ViewHolder(view) {

    private val heading = view.findViewById<TextView>(com.example.notimdb.R.id.maintitle)
    private val imageView = view.findViewById<ImageView>(com.example.notimdb.R.id.mainimg)

    fun setMovie(movie: Movies) {
        heading.text = movie.title
        Glide.with(itemView.context)
            .asBitmap()
            .override(300, 300)
            .load(movie.imageUrl)
            .into(imageView)

        imageView.setOnClickListener {
            val moviePager = Intent(itemView.context, MoviePager::class.java)
            moviePager.putExtra("obj", movie)
            itemView.context.startActivity(moviePager)
        }
    }




}
