package ru.gb.makulin.poplibslesson2.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.model.GithubUserReposModel
import ru.gb.makulin.poplibslesson2.ui.details.DetailsRepoFragment
import ru.gb.makulin.poplibslesson2.ui.repos.UserReposFragment
import ru.gb.makulin.poplibslesson2.ui.users.UsersFragment

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment.newInstance()
    }

    fun detailsUserScreen(repo: GithubUserReposModel) = FragmentScreen {
        DetailsRepoFragment.newInstance(repo)
    }

    fun reposScreen(user: GithubUserModel) = FragmentScreen {
        UserReposFragment.newInstance(user)
    }
}