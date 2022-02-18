package ru.gb.makulin.poplibslesson2.domain

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.network.GithubApi
import ru.gb.makulin.poplibslesson2.network.GithubUserDTO

class GithubUsersRepository(private val githubApi: GithubApi) : IGithubUsersRepository {
    override fun getUsers(): Single<List<GithubUserDTO>> {
        return githubApi.getUsers()
    }

}