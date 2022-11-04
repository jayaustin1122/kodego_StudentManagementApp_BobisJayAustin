package com.school.managementapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import com.google.android.material.tabs.TabLayout
import com.school.managementapplication.databinding.ActivitySubjectsOnClickDetailsBinding

class SubjectsOnClickDetails : AppCompatActivity() {
    lateinit var binding : ActivitySubjectsOnClickDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectsOnClickDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var subTitle : String? = intent.getStringExtra("subtitle")
        binding.tvSubjectTitle.text = subTitle
        var subBgOnClick : Int = intent.getIntExtra("imgBgOnclick",0)
        binding.imgBgOnClickSub.setImageResource(subBgOnClick)
//        var subDesc : String? = intent.getStringExtra("subDesc")
//        var subSched : String? = intent.getStringExtra("subSched")

        val fragmentAnnouncement = FragmentAnnouncement()
        val fragmentAssignments = FragmentAssignments()
        val fragmentSyllabus = FragmentSyllabus()
        val fragmentNotes = FragmentNotes()
        val studentHomePage = StudentHomePage()

        supportFragmentManager.beginTransaction().apply {
            replace(binding.mainFragment.id,fragmentAnnouncement)
            commit()
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0){
                    supportFragmentManager.beginTransaction().apply {
                        replace(binding.mainFragment.id,fragmentAnnouncement)
                        commit()
                    }
                }else if (tab?.position == 1) {
                    supportFragmentManager.beginTransaction().apply {
                        replace(binding.mainFragment.id, fragmentAssignments)
                        commit()
                    }
                }
                else if (tab?.position == 2) {
                    supportFragmentManager.beginTransaction().apply {
                        replace(binding.mainFragment.id, fragmentNotes)
                        commit()
                    }
                }else if (tab?.position == 3) {
                    supportFragmentManager.beginTransaction().apply {
                        replace(binding.mainFragment.id, fragmentSyllabus)
                        commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })







//        binding.textSubDesc.text = subDesc
//        binding.textSubSched.text = subSched

    }
}