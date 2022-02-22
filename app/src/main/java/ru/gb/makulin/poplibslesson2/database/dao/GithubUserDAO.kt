package ru.gb.makulin.poplibslesson2.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.database.entity.GithubUserEntity

@Dao
interface GithubUserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<GithubUserEntity>)

    @Query("SELECT * FROM GithubUserEntity")
    fun getAll(): Single<List<GithubUserEntity>>
}
