package ru.gb.makulin.poplibslesson2.domain

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.network.GithubUserDTO

interface IGithubUsersRepository {

    fun getUsers(): Single<List<GithubUserDTO>>

}