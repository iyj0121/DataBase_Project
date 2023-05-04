package com.example.planner

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planner.databinding.ItemProjectBinding
import com.example.planner.vo.Project


class ProjectListViewHolder(val binding: ItemProjectBinding): RecyclerView.ViewHolder(binding.root){
}
class ProjectListAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var projectListData = mutableListOf<Project>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return ProjectListViewHolder(ItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ProjectListViewHolder).binding
        binding.itemProjectTitle.text = projectListData[position].title
        val projectId: Int = projectListData[position].id

        binding.itemProject.setOnClickListener {
            Intent(holder.itemView.context, ProjectContentActivity::class.java).apply {
                putExtra("projectId", projectId)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run { holder.itemView.context.startActivity(this) }
        }
    }
    override fun getItemCount(): Int{
        return  projectListData?.size ?: 0
    }
}