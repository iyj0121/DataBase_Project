package com.example.planner

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planner.databinding.ItemProjectBinding
import com.example.planner.databinding.ItemTaskBinding
import com.example.planner.network.RetrofitClient
import com.example.planner.vo.Project
import com.example.planner.vo.Scheduler

class TaskListViewHolder(val binding: ItemTaskBinding): RecyclerView.ViewHolder(binding.root){
}
class TaskListAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var TaskListData = mutableListOf<Scheduler>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return TaskListViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as TaskListViewHolder).binding
        binding.itemTaskTitle.text = TaskListData[position].title
        binding.itemTaskContent.text = TaskListData[position].content
        val projectId: Int = TaskListData[position].id

//        binding.itemProject.setOnClickListener {
//            Intent(holder.itemView.context, ProjectContentActivity::class.java).apply {
//                putExtra("projectId", projectId)
//                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            }.run { holder.itemView.context.startActivity(this) }
//        }
    }
    override fun getItemCount(): Int{
        return  TaskListData ?.size ?: 0
    }

}