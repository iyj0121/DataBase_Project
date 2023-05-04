package com.example.planner.network

import com.example.planner.vo.Project
import com.example.planner.vo.Scheduler
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {

    @GET("/project")
    fun getProject(
    ): Call<List<Project>>

    @POST("/project/post")
    fun postProject(
        @Body project: Project
    ): Call<Boolean>

    @GET("/scheduler")
    fun getTask(
    ): Call<List<Scheduler>>
}