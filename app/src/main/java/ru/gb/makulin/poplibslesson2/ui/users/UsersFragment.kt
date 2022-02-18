package ru.gb.makulin.poplibslesson2.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.makulin.poplibslesson2.App
import ru.gb.makulin.poplibslesson2.databinding.FragmentUsersBinding
import ru.gb.makulin.poplibslesson2.domain.GithubUsersRepository
import ru.gb.makulin.poplibslesson2.model.GithubUserModel
import ru.gb.makulin.poplibslesson2.network.ApiHolder
import ru.gb.makulin.poplibslesson2.ui.base.BackButtonListener
import ru.gb.makulin.poplibslesson2.ui.users.adapter.UsersAdapter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val presenter by moxyPresenter {
        UsersPresenter(App.instance.router, GithubUsersRepository(ApiHolder.githubApi))
    }

    private val adapter by lazy {
        UsersAdapter(presenter::onUserClicked)
    }

    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!

    companion object {
        fun newInstance(): UsersFragment {
            return UsersFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.usersRecycler.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun updateList(users: List<GithubUserModel>) {
        adapter.submitList(users)
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }
}