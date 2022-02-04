package ru.gb.makulin.poplibslesson2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUserModel(
    val login: String
) : Parcelable
