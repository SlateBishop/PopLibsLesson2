package ru.gb.makulin.poplibslesson2.database.cache

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.network.model.GithubUserReposDTO

interface IGithubReposCache {
    fun saveCache(repos: List<GithubUserReposDTO>)
    fun loadCache(userId: Long): Single<List<GithubUserReposDTO>>
}