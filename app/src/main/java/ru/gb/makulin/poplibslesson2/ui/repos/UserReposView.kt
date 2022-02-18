package ru.gb.makulin.poplibslesson2.ui.repos

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.gb.makulin.poplibslesson2.model.GithubUserReposModel

interface UserReposView : MvpView {

    @AddToEndSingle
    fun showReposList(repos: List<GithubUserReposModel>)
}