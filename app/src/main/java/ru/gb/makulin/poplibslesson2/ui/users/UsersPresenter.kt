package ru.gb.makulin.poplibslesson2.ui.users

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.gb.makulin.poplibslesson2.domain.users.IGithubUsersRepository
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.screens.AppScreens
import ru.gb.makulin.poplibslesson2.screens.IScreens
import ru.gb.makulin.poplibslesson2.utils.convertGithubUsersFromDtoToModel
import javax.inject.Inject


class UsersPresenter @Inject constructor(
    private val router: Router,
    private val usersRepository: IGithubUsersRepository,
    private val screens: IScreens
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
        router.navigateTo(screens.reposScreen(user))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}