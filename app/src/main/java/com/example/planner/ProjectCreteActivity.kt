package com.example.planner

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import com.example.planner.databinding.ActivityProjectCreteBinding
import com.example.planner.network.RetrofitClient
import com.example.planner.vo.Project
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ProjectCreteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProjectCreteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var projectTitle = binding.ediTitle
        var projectContent = binding.ediContent
        var projectManager = binding.ediManager

        binding.ediDate.setOnClickListener {
            val today = GregorianCalendar()
            val year: Int = today.get(Calendar.YEAR)
            val month: Int = today.get(Calendar.MONTH)
            val date: Int = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this,
                { view, year, month, dayOfMonth -> binding.ediDate.setText(
                    "${year}년 ${month + 1}월 ${dayOfMonth}일"
                )
                }, year, month, date)
            dlg.show()
        }

        var project = Project()

        binding.btnCom.setOnClickListener {
            project.title = projectTitle.text.toString()
            project.content = projectContent.text.toString()
            project.manager = projectManager.text.toString()
            project.id = 7

            val call: Call<Boolean> = RetrofitClient.networkService.postProject(project)
            call.enqueue(object : Callback<Boolean> {
                override fun onResponse(
                    call: Call<Boolean>,
                    response: Response<Boolean>
                ) {
                    if (response.isSuccessful) {
                        Log.d("조회", "성공 : ${response.body()}")
                    }else Log.d("조회", "실패 : ${response.errorBody()}")
                }
                override fun onFailure(call: Call<Boolean>, t: Throwable) {
                    Log.d("조회", "실패 : $t")
                }
            })
            finish()

        }
    }
}