package ru.gb.makulin.poplibslesson2.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.gb.makulin.poplibslesson2.network.model.GithubUserDTO
import ru.gb.makulin.poplibslesson2.network.model.GithubUserReposDTO
import ru.gb.makulin.poplibslesson2.utils.GITHUB_API_URL_END_POINT_USERS
import ru.gb.makulin.poplibslesson2.utils.GITHUB_API_URL_END_POINT_USER_REPOSITORIES
import ru.gb.makulin.poplibslesson2.utils.GITHUB_API_URL_PATH_USER_REPOSITORIES

interface GithubApi {

    @GET(GITHUB_API_URL_END_POINT_USERS)
    fun getUsers(): Single<List<GithubUserDTO>>

    @GET(GITHUB_API_URL_END_POINT_USER_REPOSITORIES)
    fun getUserRepos(
        @Path(GITHUB_API_URL_PATH_USER_REPOSITORIES) userName: String
    ): Single<List<GithubUserReposDTO>>
}