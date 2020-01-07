package com.example.notimdb.Data.response

import java.io.Serializable


data class Cast(
    val id: Int,
    val fullName: String,
    val role: String,
    val imageUrl: String
) : Serializable