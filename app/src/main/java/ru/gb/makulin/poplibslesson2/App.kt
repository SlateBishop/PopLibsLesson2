package ru.gb.makulin.poplibslesson2

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import ru.gb.makulin.poplibslesson2.database.GithubDatabase
import ru.gb.makulin.poplibslesson2.di.components.DaggerAppComponent
import ru.gb.makulin.poplibslesson2.di.modules.ContextModule

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
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