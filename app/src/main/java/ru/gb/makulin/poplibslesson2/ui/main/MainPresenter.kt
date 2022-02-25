package ru.gb.makulin.poplibslesson2.ui.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.gb.makulin.poplibslesson2.screens.IScreens
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router,
    private val screen: IScreens
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}