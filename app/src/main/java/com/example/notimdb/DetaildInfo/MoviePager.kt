package com.example.notimdb.DetaildInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.movie_pager.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.notimdb.Data.response.Movies
import com.example.notimdb.R
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MoviePager : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_pager)
        val intent  = intent

        val data = intent.getSerializableExtra("obj") as Movies

        val infoFragment = InfoFragment(data)
//        val infoFr = infoFragment.newInstance(data)

        val cast = CastFragment(data)
//        val castFr = cast.newInstance(data)

        val fragmentAdapter = PagarAdapter(supportFragmentManager,infoFragment,cast)
        viewpager.adapter = fragmentAdapter

        tabs.setupWithViewPager(viewpager)
    }
}