package ru.gb.makulin.poplibslesson2.ui.users

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.gb.makulin.poplibslesson2.domain.users.GithubUsersRepository
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.screens.AppScreens
import ru.gb.makulin.poplibslesson2.utils.convertGithubUsersFromDtoToModel


class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        usersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { users ->
                viewState.updateList(convertGithubUsersFromDtoToModel(users))
            }
    }


    fun onUserClicked(user: GithubUserModel) {
        router.navigateTo(AppScreens.reposScreen(user))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}