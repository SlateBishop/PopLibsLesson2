package ru.gb.makulin.poplibslesson2.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.model.GithubUserReposModel

interface IScreens {
    fun usersScreen(): FragmentScreen

    fun detailsUserScreen(repo: GithubUserReposModel): FragmentScreen

    fun reposScreen(user: GithubUserModel): FragmentScreen
}