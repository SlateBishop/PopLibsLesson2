package ru.gb.makulin.poplibslesson2.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.model.GithubUserReposModel
import ru.gb.makulin.poplibslesson2.ui.details.DetailsRepoFragment
import ru.gb.makulin.poplibslesson2.ui.repos.UserReposFragment
import ru.gb.makulin.poplibslesson2.ui.users.UsersFragment

class AppScreens : IScreens {

    override fun usersScreen() = FragmentScreen {
        UsersFragment.newInstance()
    }

    override fun detailsUserScreen(repo: GithubUserReposModel) = FragmentScreen {
        DetailsRepoFragment.newInstance(repo)
    }

    override fun reposScreen(user: GithubUserModel) = FragmentScreen {
        UserReposFragment.newInstance(user)
    }
}