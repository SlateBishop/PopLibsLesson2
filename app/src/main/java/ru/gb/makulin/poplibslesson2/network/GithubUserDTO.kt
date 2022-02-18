package ru.gb.makulin.poplibslesson2.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUserDTO(
    val id: Long,
    val login: String,
    val avatarUrl: String
) : Parcelable
