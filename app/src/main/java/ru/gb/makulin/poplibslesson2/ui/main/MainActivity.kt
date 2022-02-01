package ru.gb.makulin.poplibslesson2.ui.main

import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.gb.makulin.poplibslesson2.App
import ru.gb.makulin.poplibslesson2.R

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

}