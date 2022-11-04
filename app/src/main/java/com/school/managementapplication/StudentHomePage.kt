package com.school.managementapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.school.managementapplication.databinding.ActivityStudentHomePageBinding

class StudentHomePage : AppCompatActivity() {
    lateinit var binding: ActivityStudentHomePageBinding
    lateinit var adapter : SubjectsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var subjectsList = mutableListOf<Subjects>(
            Subjects("Science","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"","MWF",
                R.drawable.bgsub1,"8:00 - 9:00 am"),
            Subjects("English","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"","MWF",
                R.drawable.englishbg,"9:00 - 10:00 am"),
            Subjects("Mathematics","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"","TTH",
                R.drawable.mathbg,"11:00 - 12:00 am"),
            Subjects("History","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"","TTH",
                R.drawable.historybg,"1:00 - 2:00 pm"),
            Subjects("UTS","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"","MW",
                R.drawable.utsbg,"3:00 - 5:00 pm")

        )
    var toast = Toast.makeText(applicationContext, "Please Enter Username and Password", Toast.LENGTH_SHORT).show()
    adapter = SubjectsAdapter(subjectsList)

    adapter.onItemClick = {
        val intent = Intent(this,SubjectsOnClickDetails::class.java)
        intent.putExtra("subtitle",it.subTitle)
          intent.putExtra("imgBgOnclick",it.subBg)
//        intent.putExtra("subDesc",it.subDescription)
//        intent.putExtra("subSched",it.subSchedule)
        startActivity(intent)

    }
        binding.myRecylerView.adapter = adapter
        binding.myRecylerView.layoutManager = LinearLayoutManager(this)



    var fullname: String? = intent.getStringExtra("fullname")
    binding.blankName.text = fullname
    var course : String? = intent.getStringExtra("course")
        binding.blankCourse.text = course
    var section : String? = intent.getStringExtra("section")
        binding.blankSection.text = "Class: ${section} -"
    var id : String? = intent.getStringExtra("id")
        binding.blankid.text = "ID: ${id} -"
    var sched : String? = intent.getStringExtra("sched")
        binding.blanksched.text = sched
    var image : Int = intent.getIntExtra("image1",0)
    binding.imgProfile.setImageResource(image)
    var username : String? = intent.getStringExtra("username")
    binding.tvWelcome.text = "Welcome Back! ${username}"
    }

}