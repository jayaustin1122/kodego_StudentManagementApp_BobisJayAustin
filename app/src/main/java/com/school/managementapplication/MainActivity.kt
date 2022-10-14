package com.school.managementapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.school.managementapplication.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    var correctUserName = arrayListOf<String>("Harry123","Cardo_45")
    var correctPassword = arrayListOf<String>("123456","000000")
    var numberId = arrayListOf<Int>(1,2)
    var course   = arrayListOf<String>("Multimedia and Arts","Criminology")
    var sections = arrayListOf<Char>('A','B')
    var schedule = arrayListOf<String>("Online","Face to Face")
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener{
            var username : String = binding.etUsernameEmail.text.toString()
            var password : String = binding.etPassword.text.toString()
            checkAccount(username,password)
        }

    }
    private fun checkAccount(username:String,password:String){
        var counter = 0
        for (i in correctUserName){
            if ((username.capitalize() == correctUserName[counter]) && (password == correctPassword[counter])) {
                val intent = Intent(this, StudentHomePage::class.java)
                // calling the intent
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "Welcome ${correctUserName[counter]}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "This Email or Password are not registered", Toast.LENGTH_SHORT).show()
            }
            counter++
        }

    }

}