package ru.gb.makulin.poplibslesson2.database.cache

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.database.dao.GithubUserDAO
import ru.gb.makulin.poplibslesson2.network.model.GithubUserDTO
import ru.gb.makulin.poplibslesson2.utils.convertGithubUsersFromDtoToEntity
import ru.gb.makulin.poplibslesson2.utils.convertGithubUsersFromEntityToDTO
import javax.inject.Inject

class RoomGithubUsersCache @Inject constructor(
    private val userDAO: GithubUserDAO
) : IGithubUsersCache {

    override fun saveCache(users: List<GithubUserDTO>) {
        userDAO.insert(convertGithubUsersFromDtoToEntity(users))

    }

    override fun loadCache(): Single<List<GithubUserDTO>> {
        return userDAO.getAll().map { users ->
            convertGithubUsersFromEntityToDTO(users)
        }
    }
}