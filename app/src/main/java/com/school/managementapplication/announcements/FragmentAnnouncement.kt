package com.school.managementapplication.announcements

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.school.managementapplication.Dataused
import com.school.managementapplication.databinding.FragmentAnnouncementBinding
import com.school.managementapplication.databinding.PopupDialogyesornoBinding


class FragmentAnnouncement : Fragment() {
    lateinit var adapter : AnnouncementsAdapter
    lateinit var binding : FragmentAnnouncementBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnnouncementBinding.inflate(layoutInflater)
            var datausedLists = mutableListOf<Dataused>(
                Dataused("Sample1","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample2","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample3","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample4","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample5","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample6","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample7","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample8","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample9","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample10","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample11","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample12","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
                Dataused("Sample13","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),

            )
        adapter = AnnouncementsAdapter(datausedLists)

        adapter.onItemClick1 = {
            val intent = Intent(this@FragmentAnnouncement.requireContext(), AnnouncementOnClick::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("info", it.information)
            startActivity(intent)
        }

        //delete
        adapter.onDeleteButtonClick= { item: Dataused, position:Int ->
            showDeletePopup(item,position)

        }
                binding.recyclerViewAnnouncements.adapter = adapter
                binding.recyclerViewAnnouncements.layoutManager = LinearLayoutManager(this@FragmentAnnouncement.requireContext())



        // Inflate the layout for this fragment
        return binding.root

    }
    fun showDeletePopup(item: Dataused, position:Int){
        val dialog = Dialog(this@FragmentAnnouncement.requireContext())
        val binding : PopupDialogyesornoBinding = PopupDialogyesornoBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnYes.setOnClickListener(){
            adapter.announcements.removeAt(position)
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }
        binding.btnNo.setOnClickListener(){
            dialog.dismiss()
        }
    }


}