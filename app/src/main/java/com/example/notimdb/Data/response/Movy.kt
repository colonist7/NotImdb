package com.example.notimdb.Data.response

import java.io.Serializable


data class Movies(
    val id: Int,
    val title: String,
    val date: String,
    val language: String,
    val seasons: Int,
    val imageUrl: String,
    val cast: List<Cast>
) : Serializable
