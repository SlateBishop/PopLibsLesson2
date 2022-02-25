package ru.gb.makulin.poplibslesson2.ui.repos

import dagger.assisted.AssistedFactory
import ru.gb.makulin.poplibslesson2.model.GithubUserModel

@AssistedFactory
interface UserReposPresenterFactory {
    fun presenter(userModel: GithubUserModel): UserReposPresenter
}