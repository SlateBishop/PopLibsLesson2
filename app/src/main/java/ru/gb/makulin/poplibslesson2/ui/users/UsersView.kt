package ru.gb.makulin.poplibslesson2.ui.users

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.gb.makulin.poplibslesson2.model.GithubUserModel

interface UsersView : MvpView {

    @AddToEndSingle
    fun updateList(users: List<GithubUserModel>)
}