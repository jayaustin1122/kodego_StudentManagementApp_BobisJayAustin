package com.school.managementapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.school.managementapplication.databinding.ActivityAnnouncementOnClickBinding
import com.school.managementapplication.databinding.RowAnnouncementsBinding

class AnnouncementOnClick : AppCompatActivity() {
    lateinit var binding : ActivityAnnouncementOnClickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnnouncementOnClickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var title : String? = intent.getStringExtra("title")
        var information : String? = intent.getStringExtra("info")
        binding.tvtitle.text = title
        binding.tvInformations.text = information

    }
}