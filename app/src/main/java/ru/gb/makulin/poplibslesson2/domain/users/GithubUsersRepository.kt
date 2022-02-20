package ru.gb.makulin.poplibslesson2.domain.users

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.database.dao.GithubUserDAO
import ru.gb.makulin.poplibslesson2.network.GithubApi
import ru.gb.makulin.poplibslesson2.network.NetworkStatus
import ru.gb.makulin.poplibslesson2.network.model.GithubUserDTO
import ru.gb.makulin.poplibslesson2.utils.convertGithubUsersFromDtoToEntity
import ru.gb.makulin.poplibslesson2.utils.convertGithubUsersFromEntityToDTO

class GithubUsersRepository(
    private val githubApi: GithubApi,
    private val networkStatus: NetworkStatus,
    private val userDAO: GithubUserDAO
) : IGithubUsersRepository {
    override fun getUsers(): Single<List<GithubUserDTO>> = networkStatus.isOnline().flatMap { it ->
        if (it) {
            githubApi
                .getUsers()
                .flatMap {
                    userDAO.insert(convertGithubUsersFromDtoToEntity(it))
                    Single.just(it)
                }
        } else {
            userDAO.getAll().map { users->
                convertGithubUsersFromEntityToDTO(users)
            }
        }
    }
}