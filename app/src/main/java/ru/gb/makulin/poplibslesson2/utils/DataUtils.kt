package ru.gb.makulin.poplibslesson2.utils

import ru.gb.makulin.poplibslesson2.database.entity.GithubUserEntity
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.model.GithubUserReposModel
import ru.gb.makulin.poplibslesson2.network.model.GithubUserDTO
import ru.gb.makulin.poplibslesson2.network.model.GithubUserReposDTO

fun convertGithubUsersFromDtoToModel(githubUsersDTO: List<GithubUserDTO>): List<GithubUserModel> {
    return githubUsersDTO.map {
        GithubUserModel(it.id, it.login, it.avatarUrl)
    }
}

fun convertGithubUserReposFromDtoToModel(githubUserReposDTO: List<GithubUserReposDTO>):
        List<GithubUserReposModel> {
    return githubUserReposDTO.map {
        GithubUserReposModel(it.name, it.fullName)
    }
}

fun convertGithubUsersFromDtoToEntity(userDTO: List<GithubUserDTO>): List<GithubUserEntity> {
    return userDTO.map {
        GithubUserEntity(it.id, it.login, it.avatarUrl)
    }
}

fun convertGithubUsersFromEntityToDTO(usersEntity: List<GithubUserEntity>):
        List<GithubUserDTO> {
    return usersEntity.map {
        GithubUserDTO(it.id, it.login, it.avatarUrl)
    }
}

//fun convertGithubUserReposFromDtoToEntity(repoDTO: List<GithubUserReposDTO>):
//        List<GithubUserReposEntity> {
//    return repoDTO.map {
//        GithubUserReposEntity()
//    }
//}