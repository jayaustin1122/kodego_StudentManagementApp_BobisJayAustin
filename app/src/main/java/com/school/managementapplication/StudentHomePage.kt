package com.school.managementapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.school.managementapplication.databinding.ActivityStudentHomePageBinding

class StudentHomePage : AppCompatActivity() {
    lateinit var binding: ActivityStudentHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

    var fullname: String? = intent.getStringExtra("fullname")
        binding.blankName.text = fullname
    var course : String? = intent.getStringExtra("course")
        binding.blankCourse.text = course
    var section : String? = intent.getStringExtra("section")
        binding.blankSection.text = section
    var id : String? = intent.getStringExtra("id")
        binding.blankid.text = id
    var sched : String? = intent.getStringExtra("sched")
        binding.blanksched.text = sched
    }
}