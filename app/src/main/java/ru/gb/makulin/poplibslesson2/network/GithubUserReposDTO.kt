package ru.gb.makulin.poplibslesson2.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUserReposDTO(
    val name: String,
    val fullName: String
) : Parcelable
