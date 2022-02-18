package ru.gb.makulin.poplibslesson2.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.makulin.poplibslesson2.App
import ru.gb.makulin.poplibslesson2.databinding.FragmentDetailsUserBinding
import ru.gb.makulin.poplibslesson2.model.GithubUserReposModel
import ru.gb.makulin.poplibslesson2.ui.base.BackButtonListener
import ru.gb.makulin.poplibslesson2.utils.REPO_SAVE_KEY

class DetailsRepoFragment : MvpAppCompatFragment(), DetailsRepoView, BackButtonListener {

    private val presenter by moxyPresenter {
        DetailsRepoPresenter(App.instance.router)
    }

    private var _binding: FragmentDetailsUserBinding? = null
    private val binding
        get() = _binding!!

    companion object {
        fun newInstance(repo: GithubUserReposModel): DetailsRepoFragment {
            return DetailsRepoFragment().apply {
                arguments = bundleOf(REPO_SAVE_KEY to repo)
            }
        }
    }

    private val repoModel by lazy {
        requireArguments().getParcelable<GithubUserReposModel>(REPO_SAVE_KEY)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewFullName.text = repoModel.fullName
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }
}