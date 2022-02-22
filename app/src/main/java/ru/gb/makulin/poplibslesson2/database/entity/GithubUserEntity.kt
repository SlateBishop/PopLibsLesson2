package ru.gb.makulin.poplibslesson2.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GithubUserEntity(
    @PrimaryKey val id: Long,
    val login: String,
    val avatarUrl: String
)
