package ru.gb.makulin.poplibslesson2.domain.repos

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.network.GithubUserReposDTO

interface IGithubReposRepository {

    fun getUserRepos(user: GithubUserModel): Single<List<GithubUserReposDTO>>

}