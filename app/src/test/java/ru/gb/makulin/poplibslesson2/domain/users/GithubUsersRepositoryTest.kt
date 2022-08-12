package ru.gb.makulin.poplibslesson2.domain.users

import com.nhaarman.mockito_kotlin.verify
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import ru.gb.makulin.poplibslesson2.database.cache.IGithubUsersCache
import ru.gb.makulin.poplibslesson2.network.GithubApi
import ru.gb.makulin.poplibslesson2.network.NetworkStatus
import ru.gb.makulin.poplibslesson2.network.model.GithubUserDTO

class GithubUsersRepositoryTest {

    private lateinit var repository: IGithubUsersRepository

    @Mock
    private lateinit var githubApi: GithubApi

    @Mock
    private lateinit var networkStatus: NetworkStatus

    @Mock
    private lateinit var usersCache: IGithubUsersCache

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = GithubUsersRepository(
            githubApi = githubApi,
            networkStatus = networkStatus,
            usersCache = usersCache
        )
    }

    @Test
    fun githubUsersRepository_TestNetworkStatusChecked() {
        val githubUserDTO = GithubUserDTO(id = 1, login = "empty", avatarUrl = "")
        val usersList = listOf(githubUserDTO)

        `when`(networkStatus.isOnline()).thenReturn(Single.just(true))
        `when`(githubApi.getUsers()).thenReturn(Single.just(usersList))
        repository.getUsers()
        verify(networkStatus).isOnline()
    }

    @Test
    fun githubUsersRepository_TestGetUsersOnline() {
        val githubUserDTO = GithubUserDTO(id = 1, login = "empty", avatarUrl = "")
        val usersList = listOf(githubUserDTO)

        `when`(networkStatus.isOnline()).thenReturn(Single.just(true))
        `when`(githubApi.getUsers()).thenReturn(Single.just(usersList))
        repository.getUsers()
        verify(githubApi).getUsers()
    }

    @Test
    fun githubUsersRepository_TestGetUsersOffline() {
        val githubUserDTO = GithubUserDTO(id = 1, login = "empty", avatarUrl = "")
        val usersList = listOf(githubUserDTO)

        `when`(networkStatus.isOnline()).thenReturn(Single.just(false))
        `when`(usersCache.loadCache()).thenReturn(Single.just(usersList))
        repository.getUsers()
        verify(usersCache).loadCache()
    }


}