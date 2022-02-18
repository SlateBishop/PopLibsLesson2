package ru.gb.makulin.poplibslesson2.utils

import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.network.GithubUserDTO

fun convertGithubUsersFromDtoToModel(githubUsersDTO: List<GithubUserDTO>): List<GithubUserModel> {
    return githubUsersDTO.map {
        GithubUserModel(it.id, it.login, it.avatarUrl)
    }
}