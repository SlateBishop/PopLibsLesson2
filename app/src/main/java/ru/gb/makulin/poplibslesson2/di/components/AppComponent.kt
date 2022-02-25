package ru.gb.makulin.poplibslesson2.di.components

import dagger.Component
import ru.gb.makulin.poplibslesson2.di.modules.*
import ru.gb.makulin.poplibslesson2.ui.main.MainActivity
import javax.inject.Singleton

@Component(
    modules = [
        ContextModule::class,
        DatabaseModule::class,
        NavigationModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)


}