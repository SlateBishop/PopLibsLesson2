package ru.gb.makulin.poplibslesson2.domain

import io.reactivex.rxjava3.core.Observable
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import java.util.concurrent.TimeUnit

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

    fun getUsers(): Observable<GithubUserModel> {
        val observableInterval: Observable<Long> = Observable.interval(1000, TimeUnit.MILLISECONDS)
        val observableUsers: Observable<GithubUserModel> = Observable.fromIterable(users)
        return Observable.zip(
            observableInterval,
            observableUsers
        ) { observableInterval, observableUsers ->
            observableUsers
        }
    }
}