package com.school.managementapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.managementapplication.databinding.FragmentNotesBinding

class FragmentNotes : Fragment() {

    lateinit var binding: FragmentNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
}