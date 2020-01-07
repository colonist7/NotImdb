package com.example.notimdb.DetaildInfo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notimdb.Data.response.Cast
import com.bumptech.glide.Glide
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.annotation.GlideModule


@GlideModule
class MyAppGlideModule : AppGlideModule()// leave empty for now

class CastListViewHolder (
    view: View
) : RecyclerView.ViewHolder(view) {

    private val heading = view.findViewById<TextView>(com.example.notimdb.R.id.heading)
    private val info = view.findViewById<TextView>(com.example.notimdb.R.id.info)
    private val imageView = view.findViewById<ImageView>(com.example.notimdb.R.id.img)

    fun setCast(cast: Cast) {
        heading.text = cast.fullName
        info.text = cast.role
        Glide.with(itemView.context)
            .asBitmap()
            .override(100, 100)
            .load(cast.imageUrl)
            .into(imageView)
    }

}
