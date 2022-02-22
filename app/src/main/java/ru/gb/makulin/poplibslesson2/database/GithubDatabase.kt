package ru.gb.makulin.poplibslesson2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.gb.makulin.poplibslesson2.database.dao.GithubUserDAO
import ru.gb.makulin.poplibslesson2.database.dao.GithubUserReposDAO
import ru.gb.makulin.poplibslesson2.database.entity.GithubUserEntity
import ru.gb.makulin.poplibslesson2.database.entity.GithubUserReposEntity

@Database(entities = [GithubUserReposEntity::class, GithubUserEntity::class], version = 1)
abstract class GithubDatabase : RoomDatabase() {

    abstract val userDao: GithubUserDAO
    abstract val reposDao: GithubUserReposDAO

    companion object {
        private const val DB_NAME = "database.db"
        private var instance: GithubDatabase? = null

        fun getInstance(context: Context): GithubDatabase {
            if (instance == null) {
                instance = Room
                    .databaseBuilder(context, GithubDatabase::class.java, DB_NAME)
                    .build()
            }
            return instance!!
        }
    }
}