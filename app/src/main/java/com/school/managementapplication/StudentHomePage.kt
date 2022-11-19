package com.school.managementapplication

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.school.managementapplication.Subjects.Subjects
import com.school.managementapplication.Subjects.SubjectsAdapter
import com.school.managementapplication.Subjects.SubjectsOnClickDetails
import com.school.managementapplication.databinding.ActivityStudentHomePageBinding
import com.school.managementapplication.databinding.CameraGalleryDialogBinding

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
    adapter = SubjectsAdapter(subjectsList)

    adapter.onItemClick = {
        val intent = Intent(this, SubjectsOnClickDetails::class.java)
        intent.putExtra("subtitle",it.subTitle)
          intent.putExtra("imgBgOnclick",it.subBg)
//        intent.putExtra("subDesc",it.subDescription)
//        intent.putExtra("subSched",it.subSchedule)
        startActivity(intent)

    }
        binding.imgBtnChangeEdit.setOnClickListener(){
            showCustomDialog()
            binding.imgBtnChangeEdit.setImageResource(R.drawable.ic_baseline_edit_24)
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
    private fun showCustomDialog(){
        //binding the dialog xml
        val customDialog: Dialog = Dialog(this)
        var dialogBinding : CameraGalleryDialogBinding = CameraGalleryDialogBinding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)


        //calling buttons yes and no

        dialogBinding.btnCamera.setOnClickListener() {
            showCamera()
            customDialog.dismiss()
        }
        dialogBinding.btnGallery.setOnClickListener(){
            showGallery()
            customDialog.dismiss()
        }
        customDialog.show()
    }
    // to access camera.
    private fun showCamera() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.CAMERA
        ).withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
                //show camera
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                //declare the camera

                cameraLauncher.launch(cameraIntent)
//                startActivity(cameraIntent) // to go to camera only we cannot get an output or the image.
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request : PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check() // to show the permission
    }
    private fun showGallery() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                galleryLauncher.launch(galleryIntent)
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request : PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check() // to show the permission
    }
    // handle data or images from the camera
    val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.extras.let {
                val image : Bitmap = result.data?.extras?.get("data") as Bitmap // get only the image.
                binding.imgProfile.setImageBitmap(image)
            }
        }

    }
    // handle data or images in Gallery
    val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let {
                val selectedImage = result.data?.data
                binding.imgProfile.setImageURI(selectedImage)
            }

        }
    }
    private fun gotoSettings() {
        AlertDialog.Builder(this).setMessage("Permission is Denied Go to Settings to Change it to allow.")
            .setPositiveButton("Go to Settings"){ dialog, item ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                var uri = Uri.fromParts("package",packageName,null)
                intent.data = uri
                startActivity(intent)
            }.setNegativeButton("Cancel"){ dialog, item ->
                dialog.dismiss()
            }.show()

    }


}