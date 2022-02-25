package ru.gb.makulin.poplibslesson2.di.modules

import dagger.Binds
import dagger.Module
import ru.gb.makulin.poplibslesson2.domain.repos.GithubReposRepository
import ru.gb.makulin.poplibslesson2.domain.repos.IGithubReposRepository
import ru.gb.makulin.poplibslesson2.domain.users.GithubUsersRepository
import ru.gb.makulin.poplibslesson2.domain.users.IGithubUsersRepository
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideUserRepository(implementation: GithubUsersRepository): IGithubUsersRepository

    @Binds
    @Singleton
    fun provideReposRepository(implementation: GithubReposRepository): IGithubReposRepository

}