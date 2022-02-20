package ru.gb.makulin.poplibslesson2.domain.repos

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.network.GithubApi
import ru.gb.makulin.poplibslesson2.network.model.GithubUserReposDTO

class GithubReposRepository(private val githubApi: GithubApi) : IGithubReposRepository {
    override fun getUserRepos(user: GithubUserModel): Single<List<GithubUserReposDTO>> {
        return githubApi.getUserRepos(user.login)
    }
}