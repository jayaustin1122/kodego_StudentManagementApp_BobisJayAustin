package com.school.managementapplication.notes

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.school.managementapplication.Dataused
import com.school.managementapplication.announcements.AnnouncementOnClick
import com.school.managementapplication.databinding.AddDialogBinding
import com.school.managementapplication.databinding.FragmentNotesBinding
import com.school.managementapplication.databinding.PopupDialogyesornoBinding
import com.school.managementapplication.databinding.UpdateDialogBinding

class FragmentNotes : Fragment() {
    lateinit var adapter : NotesAdapter
    lateinit var binding: FragmentNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(layoutInflater)
        var datausedLists = mutableListOf<Dataused>(
            Dataused("Notes 1","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 2","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 3","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 4","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 5","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 6","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 7","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 8","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 9","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 10","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 11","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 12","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Notes 13","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),

        )
        adapter = NotesAdapter(datausedLists)

        adapter.onItemClick = {
            val intent = Intent(this@FragmentNotes.requireContext(), AnnouncementOnClick::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("info", it.information)
            startActivity(intent)
        }
        //delete
        adapter.onDeleteButtonClick= { item: Dataused, position:Int ->
            showDeletePopup(item,position)

        }
        //update
        adapter.onUpdateButtonClick = { item:Dataused, position:Int ->
            showUpdateDialog(item,position)
        }
        //Adding button floating in home
        binding.floatingActionButton.setOnClickListener(){
            showAddDialog()
        }
            binding.recyclerViewNotes.adapter = adapter
            binding.recyclerViewNotes.layoutManager = LinearLayoutManager(this@FragmentNotes.requireContext())

        // Inflate the layout for this fragment
        return binding.root
    }
    fun showAddDialog(){
        val dialog = Dialog(this.requireContext())
        val binding : AddDialogBinding = AddDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnAddItem.setOnClickListener(){
            var title : String = binding.etTitleNotes.text.toString()
            var info : String = binding.etInfoNotes.text.toString()
            //add data
            adapter.notes.add(Dataused(title,info))
            adapter.notifyItemInserted(adapter.itemCount +1)
            dialog.dismiss()
        }



    }
    fun showDeletePopup(item: Dataused, position:Int){
        val dialog = Dialog(this@FragmentNotes.requireContext())
        val binding : PopupDialogyesornoBinding = PopupDialogyesornoBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnYes.setOnClickListener(){
            adapter.notes.removeAt(position)
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }
        binding.btnNo.setOnClickListener(){
            dialog.dismiss()
        }
    }
    //updating quantity dialog
    fun showUpdateDialog(item:Dataused,position: Int){
        val dialog = Dialog(this@FragmentNotes.requireContext())
        val binding : UpdateDialogBinding = UpdateDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()

        binding.btnUpdate.setOnClickListener (){
            var newTitle : String = binding.etTitle.text.toString()
            var newInfo : String = binding.etInfo.text.toString()
            adapter.notes[position].title = newTitle
            adapter.notes[position].information = newInfo
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }
    }
}