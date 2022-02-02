package ru.gb.makulin.poplibslesson2.ui.base

interface IListPresenter<V : IItemView> {

    var itemClickListener: (V) -> Unit

    fun getCount(): Int

    fun bindView(view: V)
}