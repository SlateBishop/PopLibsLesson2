package ru.gb.makulin.poplibslesson2.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.makulin.poplibslesson2.App
import ru.gb.makulin.poplibslesson2.database.cache.RoomGithubReposCache
import ru.gb.makulin.poplibslesson2.databinding.FragmentReposBinding
import ru.gb.makulin.poplibslesson2.domain.repos.GithubReposRepository
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.model.GithubUserReposModel
import ru.gb.makulin.poplibslesson2.network.ApiHolder
import ru.gb.makulin.poplibslesson2.network.NetworkStatus
import ru.gb.makulin.poplibslesson2.ui.base.BackButtonListener
import ru.gb.makulin.poplibslesson2.ui.repos.adapter.UserReposAdapter
import ru.gb.makulin.poplibslesson2.utils.USER_SAVE_KEY

class UserReposFragment : MvpAppCompatFragment(), UserReposView, BackButtonListener {

    private val presenter by moxyPresenter {
        UserReposPresenter(
            App.instance.router,
            GithubReposRepository(
                ApiHolder.githubApi,
                NetworkStatus(requireContext()),
                RoomGithubReposCache(App.instance.database.reposDao)
            ),
            userModel
        )
    }

    private val userModel by lazy {
        requireArguments().getParcelable<GithubUserModel>(USER_SAVE_KEY)!!
    }

    private val adapter by lazy {
        UserReposAdapter(presenter::onRepoClicked)
    }

    private var _binding: FragmentReposBinding? = null
    private val binding
        get() = _binding!!

    companion object {
        fun newInstance(user: GithubUserModel): UserReposFragment {
            return UserReposFragment().apply {
                arguments = bundleOf(USER_SAVE_KEY to user)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReposBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.reposRecycler.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun showReposList(repos: List<GithubUserReposModel>) {
        adapter.submitList(repos)
    }
}