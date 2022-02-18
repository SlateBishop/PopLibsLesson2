package ru.gb.makulin.poplibslesson2.ui.details

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class DetailsRepoPresenter(
    private val router: Router
) : MvpPresenter<DetailsRepoView>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}