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


    }
}