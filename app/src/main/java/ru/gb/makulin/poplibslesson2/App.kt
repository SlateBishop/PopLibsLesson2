package ru.gb.makulin.poplibslesson2

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import ru.gb.makulin.poplibslesson2.database.GithubDatabase

class App : Application() {



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