package ru.gb.makulin.poplibslesson2

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import ru.gb.makulin.poplibslesson2.database.GithubDatabase

class App : Application() {

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    val navigatorHolder
        get() = cicerone.getNavigatorHolder()

    val router
        get() = cicerone.router

    val database by lazy {
        GithubDatabase.getInstance(this)
    }

    companion object {
        private var _instance: App? = null
        val instance
            get() = _instance!!
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }
}