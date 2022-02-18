package ru.gb.makulin.poplibslesson2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUserReposModel(
    val name: String,
    val fullName: String
) : Parcelable
