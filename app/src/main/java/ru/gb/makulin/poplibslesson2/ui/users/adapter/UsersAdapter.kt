package ru.gb.makulin.poplibslesson2.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gb.makulin.poplibslesson2.databinding.FragmentUsersItemBinding
import ru.gb.makulin.poplibslesson2.ui.users.UserItemView
import ru.gb.makulin.poplibslesson2.ui.users.UsersPresenter

class UsersAdapter(
    private val presenter: UsersPresenter.UsersListPresenter
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = FragmentUsersItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return UserViewHolder(binding).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener()
            }
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        presenter.bindView(
            holder.apply {
                pos = position
            }
        )
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }


    inner class UserViewHolder(private val binding: FragmentUsersItemBinding) : RecyclerView
    .ViewHolder(binding.root), UserItemView {

        override fun setLogin(login: String) {
            binding.textViewLogin.text = login
        }

        override var pos = -1
    }
}