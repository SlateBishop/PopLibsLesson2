package ru.gb.makulin.poplibslesson2.ui.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.gb.makulin.poplibslesson2.domain.GithubUsersRepository
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.screens.AppScreens
import ru.gb.makulin.poplibslesson2.ui.base.IListPresenter

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository
) : MvpPresenter<UsersView>() {

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
        usersListPresenter.itemClickListener = {
            router.navigateTo(AppScreens.detailsUserScreen(it.getLogin()))
        }
    }

    private fun loadData() {
        val users = usersRepository.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }


    class UsersListPresenter : IListPresenter<UserItemView> {

        val users = mutableListOf<GithubUserModel>()

        override var itemClickListener: (UserItemView) -> Unit = {}

        override fun getCount(): Int = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
}