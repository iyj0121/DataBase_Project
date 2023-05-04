package com.example.planner

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.planner.databinding.ActivityHomeBinding
import com.example.planner.network.RetrofitClient
import com.example.planner.vo.Project
import com.example.planner.vo.Scheduler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.util.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        val projectListAdapter = ProjectListAdapter()

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = projectListAdapter
        ProjectListAdapter().notifyDataSetChanged()

        projectListAdapter.notifyDataSetChanged()
//
//        val call: Call<List<Project>> = RetrofitClient.networkService.getProject()
//        call.enqueue(object : Callback<List<Project>> {
//            override fun onResponse(
//                call: Call<List<Project>>,
//                response: Response<List<Project>>
//            ) {
//                if (response.isSuccessful) {
//                    Log.d("데이터2",response.body().toString())
//                    var projectList: MutableList<Project>? =
//                        response.body() as MutableList<Project>??
//                    if (projectList!= null && projectList.size > 0) {
//                        for(i in 0 until projectList.size) {
//                            projectListAdapter.projectListData.add(projectList[i])
//                            projectListAdapter.notifyDataSetChanged()
//                        }
//                    }
//
//                }else Log.d("조회1", "실패 : ${response.errorBody()}")
//            }override fun onFailure(call: Call<List<Project>>, t: Throwable) {
//                Log.d("조회2", "실패 : $t")
//            }
//        })
//        ProjectListAdapter().notifyDataSetChanged()

        val call: Call<List<Scheduler>> = RetrofitClient.networkService.getTask()
        call.enqueue(object : Callback<List<Scheduler>> {
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
                                for(i in 0 until Scheduler.size) {
                                    if(Scheduler[i].user_id == 1){
                                                val call: Call<List<Project>> = RetrofitClient.networkService.getProject()
                                                call.enqueue(object : Callback<List<Project>> {
                                                    override fun onResponse(
                                                        call: Call<List<Project>>,
                                                        response: Response<List<Project>>
                                                    ) {
                                                        if (response.isSuccessful) {
                                                            Log.d("데이터2",response.body().toString())
                                                            var projectList: MutableList<Project>? =
                                                                response.body() as MutableList<Project>??
                                                            if (projectList!= null && projectList.size > 0) {
                                                                for(j in 0 until projectList.size) {
                                                                    if(projectList[j].id == Scheduler?.get(i).project_id)
                                                                    projectListAdapter.projectListData.add(projectList[j])
                                                                    projectListAdapter.notifyDataSetChanged()
                                                                }
                                                            }

                                                        }else Log.d("조회1", "실패 : ${response.errorBody()}")
                                                    }override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                                                        Log.d("조회2", "실패 : $t")
                                                    }
                                                })
                                        ProjectListAdapter().notifyDataSetChanged()
                                        Log.d("데이터3", Scheduler?.get(i).project_id.toString())
                                    }
                                    projectListAdapter.notifyDataSetChanged()
                                }
                            }
                        }
                    }

                }else Log.d("조회1", "실패 : ${response.errorBody()}")
            }override fun onFailure(call: Call<List<Scheduler>>, t: Throwable) {
                Log.d("조회2", "실패 : $t")
            }
        })
        ProjectListAdapter().notifyDataSetChanged()

        binding.createProject.setOnClickListener {
            val intent = Intent(this, ProjectCreteActivity::class.java)
            startActivity(intent)
        }
    }
}
