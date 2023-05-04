package com.example.planner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.planner.databinding.ActivityProjectContentBinding
import com.example.planner.network.RetrofitClient
import com.example.planner.vo.Project
import com.example.planner.vo.Scheduler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProjectContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val projectId = intent.getIntExtra("projectId",0)
        var projectName = binding.textProjectName
        var projectContent =binding.textProjectContent
        var projectMember = binding.textMember

        val layoutManager = LinearLayoutManager(this)
        val taskListAdapter = TaskListAdapter()

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = taskListAdapter
        ProjectListAdapter().notifyDataSetChanged()

        taskListAdapter.notifyDataSetChanged()
        if (projectId > 2){
            projectName.text = "test title"
            projectContent.text = "test content"
            projectMember.text = "1"
        }else{
            val call1: Call<List<Project>> = RetrofitClient.networkService.getProject()
            call1.enqueue(object : Callback<List<Project>> {
                override fun onResponse(
                    call: Call<List<Project>>,
                    response: Response<List<Project>>
                ) {
                    if (response.isSuccessful) {
                        Log.d("데이터2",response.body().toString())
                        var projectList: MutableList<Project>? =
                            response.body() as MutableList<Project>??
                        projectName.text = projectList?.get(projectId-1)?.title
                        projectContent.text = projectList?.get(projectId-1)?.content

                    }else Log.d("조회1", "실패 : ${response.errorBody()}")
                }override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                    Log.d("조회2", "실패 : $t")
                }
            })

            val call3: Call<List<Scheduler>> = RetrofitClient.networkService.getTask()
            call3.enqueue(object : Callback<List<Scheduler>> {
                override fun onResponse(
                    call: Call<List<Scheduler>>,
                    response: Response<List<Scheduler>>
                ) {
                    if (response.isSuccessful) {
                        Log.d("데이터2",response.body().toString())
                        var Scheduler: MutableList<Scheduler>? =
                            response.body() as MutableList<Scheduler>??
                        if (Scheduler != null) {
                            if (Scheduler != null && Scheduler.size > 0) {
                                if (Scheduler != null) {
                                    projectMember.text = Scheduler[0].user_id.toString()
                                    for(i in 1 until Scheduler.size) {
                                        if(Scheduler[i].project_id== projectId){
                                            projectMember.text = "1 "+ Scheduler[i].user_id.toString()
                                        }
                                    }
                                }
                            }
                        }

                    }else Log.d("조회1", "실패 : ${response.errorBody()}")
                }override fun onFailure(call: Call<List<Scheduler>>, t: Throwable) {
                    Log.d("조회2", "실패 : $t")
                }
            })

            val call: Call<List<Scheduler>> = RetrofitClient.networkService.getTask()
            call.enqueue(object : Callback<List<Scheduler>> {
                override fun onResponse(
                    call: Call<List<Scheduler>>,
                    response: Response<List<Scheduler>>
                ) {
                    if (response.isSuccessful) {
                        Log.d("데이터2",response.body().toString())
                        var projectList: MutableList<Scheduler>? =
                            response.body() as MutableList<Scheduler>??
                        if (projectList!= null && projectList.size > 0) {
                            for(i in 0 until projectList.size) {
                                if(projectId == projectList[i].project_id){
                                    taskListAdapter.TaskListData.add(projectList[i])
                                }
                                taskListAdapter.TaskListData.add(projectList[i])
                                taskListAdapter.notifyDataSetChanged()
                            }
                        }

                    }else Log.d("조회1", "실패 : ${response.errorBody()}")
                }override fun onFailure(call: Call<List<Scheduler>>, t: Throwable) {
                    Log.d("조회2", "실패 : $t")
                }
            })
            ProjectListAdapter().notifyDataSetChanged()
        }


        val call2: Call<List<Scheduler>> = RetrofitClient.networkService.getTask()
        call2.enqueue(object : Callback<List<Scheduler>> {
            override fun onResponse(
                call: Call<List<Scheduler>>,
                response: Response<List<Scheduler>>
            ) {
                if (response.isSuccessful) {
                    var projectList: MutableList<Project>? =
                        response.body() as MutableList<Project>??
                    Log.d("데이터2",response.body().toString())
                    var Scheduler: MutableList<Scheduler>? =
                        response.body() as MutableList<Scheduler>??
                    if (Scheduler != null) {
                        if (com.example.planner.vo.Scheduler != null && Scheduler.size > 0) {
                            if (Scheduler != null) {
                                projectMember.text = Scheduler[0].user_id.toString()
                                for(i in 1 until Scheduler.size) {
                                    if(Scheduler[i].project_id== projectId){
                                        projectMember.text = "1 "+ Scheduler[i].user_id.toString()
                                    }
                                }
                            }
                        }
                    }

                }else Log.d("조회1", "실패 : ${response.errorBody()}")
            }override fun onFailure(call: Call<List<Scheduler>>, t: Throwable) {
                Log.d("조회2", "실패 : $t")
            }
        })


        binding.createProject.setOnClickListener {
            finish()
        }
    }
}