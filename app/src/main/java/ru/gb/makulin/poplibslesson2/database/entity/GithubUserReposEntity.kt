package ru.gb.makulin.poplibslesson2.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = GithubUserEntity::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = CASCADE
    )]
)
data class GithubUserReposEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val fullName: String,
    val userId: Long
)
