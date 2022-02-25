package ru.gb.makulin.poplibslesson2.di.components

import dagger.Component
import ru.gb.makulin.poplibslesson2.di.modules.*
import ru.gb.makulin.poplibslesson2.ui.main.MainActivity
import ru.gb.makulin.poplibslesson2.ui.main.MainPresenter
import ru.gb.makulin.poplibslesson2.ui.repos.UserReposPresenterFactory
import ru.gb.makulin.poplibslesson2.ui.users.UsersPresenter
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

    fun provideMainPresenter(): MainPresenter

    fun provideUsersPresenter(): UsersPresenter

    fun provideReposPresenterFactory(): UserReposPresenterFactory
}