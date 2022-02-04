package ru.gb.makulin.poplibslesson2.ui.users

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import ru.gb.makulin.poplibslesson2.domain.GithubUsersRepository
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.screens.AppScreens


class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository
) : MvpPresenter<UsersView>() {

    private val usersList = mutableListOf<GithubUserModel>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {

        usersRepository.getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                usersList.add(it)
                viewState.updateList(usersList)
            }

    }

    fun onUserClicked(user: GithubUserModel) {
        router.navigateTo(AppScreens.detailsUserScreen(user))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}