package ru.gb.makulin.poplibslesson2.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.gb.makulin.poplibslesson2.databinding.FragmentUsersItemBinding
import ru.gb.makulin.poplibslesson2.model.GithubUserModel

class UsersAdapter(
    private val itemClickListener: (GithubUserModel) -> Unit
) : ListAdapter<GithubUserModel, UsersAdapter.UserViewHolder>(GithubUserItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = FragmentUsersItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.showUser(currentList[position])
    }

    inner class UserViewHolder(private val binding: FragmentUsersItemBinding) : RecyclerView
    .ViewHolder(binding.root) {

        fun showUser(user: GithubUserModel) {
            binding.root.setOnClickListener {
                itemClickListener(user)
            }
            binding.textViewLogin.text = user.login
        }
    }
}

object GithubUserItemCallback : DiffUtil.ItemCallback<GithubUserModel>() {
    override fun areItemsTheSame(oldItem: GithubUserModel, newItem: GithubUserModel): Boolean {
//        return oldItem == newItem
        return false
    }

    override fun areContentsTheSame(oldItem: GithubUserModel, newItem: GithubUserModel): Boolean {
//        return oldItem == newItem
        return false
    }
}