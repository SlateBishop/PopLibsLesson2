package ru.gb.makulin.poplibslesson2.ui.repos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.gb.makulin.poplibslesson2.databinding.FragmentReposItemBinding
import ru.gb.makulin.poplibslesson2.model.GithubUserReposModel

class UserReposAdapter(
    private val itemClickListener: (GithubUserReposModel) -> Unit
) : ListAdapter<GithubUserReposModel, UserReposAdapter.ReposViewHolder>(GithubReposItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val binding = FragmentReposItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ReposViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.showRepo(currentList[position])
    }

    inner class ReposViewHolder(private val binding: FragmentReposItemBinding) : RecyclerView
    .ViewHolder(binding.root) {

        fun showRepo(repo: GithubUserReposModel) {
            with(binding) {
                root.setOnClickListener {
                    itemClickListener(repo)
                }
                textViewRepoName.text = repo.name
            }
        }
    }
}

object GithubReposItemCallback : DiffUtil.ItemCallback<GithubUserReposModel>() {
    override fun areItemsTheSame(
        oldItem: GithubUserReposModel,
        newItem: GithubUserReposModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: GithubUserReposModel,
        newItem: GithubUserReposModel
    ): Boolean {
        return oldItem == newItem
    }
}