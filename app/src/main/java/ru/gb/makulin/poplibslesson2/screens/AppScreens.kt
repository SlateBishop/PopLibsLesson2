package ru.gb.makulin.poplibslesson2.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.gb.makulin.poplibslesson2.ui.users.UsersFragment

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment.newInstance()
    }
}