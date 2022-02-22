package ru.gb.makulin.poplibslesson2.domain.users

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.database.cache.IGithubUsersCache
import ru.gb.makulin.poplibslesson2.network.GithubApi
import ru.gb.makulin.poplibslesson2.network.NetworkStatus
import ru.gb.makulin.poplibslesson2.network.model.GithubUserDTO

class GithubUsersRepository(
    private val githubApi: GithubApi,
    private val networkStatus: NetworkStatus,
    private val usersCache: IGithubUsersCache
) : IGithubUsersRepository {
    override fun getUsers(): Single<List<GithubUserDTO>> =
        networkStatus.isOnline().flatMap { isOnline ->
            if (isOnline) {
                githubApi
                    .getUsers()
                    .flatMap {
                        usersCache.saveCache(it)
                        Single.just(it)
                    }
            } else {
                usersCache.loadCache()
            }
        }
}