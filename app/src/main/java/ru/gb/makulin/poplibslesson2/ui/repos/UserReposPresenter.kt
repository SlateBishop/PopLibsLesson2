package ru.gb.makulin.poplibslesson2.ui.repos

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.gb.makulin.poplibslesson2.domain.repos.IGithubReposRepository
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.model.GithubUserReposModel
import ru.gb.makulin.poplibslesson2.screens.AppScreens
import ru.gb.makulin.poplibslesson2.utils.convertGithubUserReposFromDtoToModel


class UserReposPresenter(
    private val router: Router,
    private val reposRepository: IGithubReposRepository,
    private val userModel: GithubUserModel
) : MvpPresenter<UserReposView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        reposRepository.getUserRepos(userModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { repos ->
                viewState.showReposList(convertGithubUserReposFromDtoToModel(repos))
            }
    }

    fun onRepoClicked(repo: GithubUserReposModel) {
        router.navigateTo(AppScreens.detailsUserScreen(repo))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}