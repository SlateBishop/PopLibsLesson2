package ru.gb.makulin.poplibslesson2.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.gb.makulin.poplibslesson2.database.GithubDatabase
import ru.gb.makulin.poplibslesson2.database.cache.IGithubReposCache
import ru.gb.makulin.poplibslesson2.database.cache.IGithubUsersCache
import ru.gb.makulin.poplibslesson2.database.cache.RoomGithubReposCache
import ru.gb.makulin.poplibslesson2.database.cache.RoomGithubUsersCache
import ru.gb.makulin.poplibslesson2.database.dao.GithubUserDAO
import ru.gb.makulin.poplibslesson2.database.dao.GithubUserReposDAO
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): GithubDatabase = GithubDatabase.getInstance(context)

    @Provides
    @Singleton
    fun providesUserDAO(database: GithubDatabase): GithubUserDAO = database.userDao

    @Provides
    @Singleton
    fun providesReposDAO(database: GithubDatabase): GithubUserReposDAO = database.reposDao

    @Provides
    @Singleton
    fun provideGithubUserCache(userDao: GithubUserDAO): IGithubUsersCache =
        RoomGithubUsersCache(userDao)

    @Provides
    @Singleton
    fun provideGithubReposCache(reposDAO: GithubUserReposDAO): IGithubReposCache =
        RoomGithubReposCache(reposDAO)
}