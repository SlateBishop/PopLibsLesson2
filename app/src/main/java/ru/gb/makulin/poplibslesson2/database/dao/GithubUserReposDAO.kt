package ru.gb.makulin.poplibslesson2.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.database.entity.GithubUserReposEntity

@Dao
interface GithubUserReposDAO {

    @Insert(onConflict = REPLACE)
    fun insert(repos: List<GithubUserReposEntity>)

    @Query("SELECT * FROM GithubUserReposEntity WHERE userId = :userId")
    fun getAllUserRepos(userId: Long): Single<List<GithubUserReposEntity>>
}