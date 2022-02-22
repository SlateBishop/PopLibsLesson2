package ru.gb.makulin.poplibslesson2.database.cache

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.database.dao.GithubUserReposDAO
import ru.gb.makulin.poplibslesson2.network.model.GithubUserReposDTO
import ru.gb.makulin.poplibslesson2.utils.convertGithubUserReposFromDtoToEntity
import ru.gb.makulin.poplibslesson2.utils.convertGithubUserReposFromEntityToDto

class RoomGithubReposCache(
    private val reposDAO: GithubUserReposDAO
) : IGithubReposCache {

    override fun saveCache(repos: List<GithubUserReposDTO>) {
        reposDAO.insert(convertGithubUserReposFromDtoToEntity(repos))
    }

    override fun loadCache(userId: Long): Single<List<GithubUserReposDTO>> {
        return reposDAO.getAllUserRepos(userId).map { repos ->
            convertGithubUserReposFromEntityToDto(repos)
        }
    }
}