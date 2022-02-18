package ru.gb.makulin.poplibslesson2.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.gb.makulin.poplibslesson2.utils.GITHUB_API_URL_END_POINT_USERS

interface GithubApi {

    @GET(GITHUB_API_URL_END_POINT_USERS)
    fun getUsers(): Single<List<GithubUserDTO>>
}