package ru.gb.makulin.poplibslesson2.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.makulin.poplibslesson2.App
import ru.gb.makulin.poplibslesson2.databinding.FragmentDetailsUserBinding
import ru.gb.makulin.poplibslesson2.utils.USER_DETAILS_LOGIN_SAVE_KEY

class DetailsUserFragment : MvpAppCompatFragment(), DetailsUserView {

    private val presenter by moxyPresenter {
        DetailsUserPresenter(App.instance.router)
    }

    private var _binding: FragmentDetailsUserBinding? = null
    private val binding
        get() = _binding!!

    companion object {
        fun newInstance(login: String): DetailsUserFragment {
            val fragment = DetailsUserFragment()
            val bundle = Bundle()
            bundle.putString(USER_DETAILS_LOGIN_SAVE_KEY, login)
            fragment.arguments = bundle
            return fragment
        }
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
        binding.textViewLogin.text = arguments?.getString(USER_DETAILS_LOGIN_SAVE_KEY)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}