package ru.gb.makulin.poplibslesson2.ui.users

import ru.gb.makulin.poplibslesson2.ui.base.IItemView

interface UserItemView : IItemView {
    fun setLogin(login: String)
    fun getLogin(): String
}