package ru.gb.makulin.poplibslesson2.domain

import ru.gb.makulin.poplibslesson2.model.GithubUserModel

class GithubUsersRepository {

    private val users = listOf<GithubUserModel>(
        GithubUserModel("user1"),
        GithubUserModel("user2"),
        GithubUserModel("user3"),
        GithubUserModel("user4"),
        GithubUserModel("user5"),
        GithubUserModel("user6"),
        GithubUserModel("user7")
    )

    fun getUsers(): List<GithubUserModel> = users
}