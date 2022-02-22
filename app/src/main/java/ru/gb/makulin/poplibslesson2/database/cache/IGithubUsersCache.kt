package ru.gb.makulin.poplibslesson2.database.cache

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.network.model.GithubUserDTO

interface IGithubUsersCache {
    fun saveCache(users: List<GithubUserDTO>)
    fun loadCache(): Single<List<GithubUserDTO>>
}