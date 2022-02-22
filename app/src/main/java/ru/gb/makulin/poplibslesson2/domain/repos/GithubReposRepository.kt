package ru.gb.makulin.poplibslesson2.domain.repos

import io.reactivex.rxjava3.core.Single
import ru.gb.makulin.poplibslesson2.database.cache.IGithubReposCache
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.network.GithubApi
import ru.gb.makulin.poplibslesson2.network.NetworkStatus
import ru.gb.makulin.poplibslesson2.network.model.GithubUserReposDTO

class GithubReposRepository(
    private val githubApi: GithubApi,
    private val networkStatus: NetworkStatus,
    private val reposCache: IGithubReposCache
) : IGithubReposRepository {
    override fun getUserRepos(user: GithubUserModel): Single<List<GithubUserReposDTO>> =
        networkStatus.isOnline().flatMap { isOnline ->
            if (isOnline) {
                githubApi
                    .getUserRepos(user.login)
                    .flatMap {
                        reposCache.saveCache(it)
                        Single.just(it)
                    }
            } else {
                reposCache.loadCache(user.id)
            }
        }
}
