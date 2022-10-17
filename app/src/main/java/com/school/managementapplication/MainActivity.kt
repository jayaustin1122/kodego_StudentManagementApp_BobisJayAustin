package com.school.managementapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.school.managementapplication.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var correctUserName = arrayListOf<String>("Harry123","Cardo_45")
    var fullNames = arrayListOf<String>("Harry Potter","Cardo Dalisay")
    var correctPassword = arrayListOf<String>("123456","000000")
    var numberId = arrayListOf<String>("1122","3344")
    var course   = arrayListOf<String>("Multimedia and Arts","Criminology")
    var sections = arrayListOf<String>("A","B")
    var schedule = arrayListOf<String>("Online","Face to Face")
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener {
            var username: String = binding.etUserName.text.toString()
            var password: String = binding.etPassword.text.toString()
            checkAccount(username, password)
        }
    }
    private fun checkAccount(username:String,password:String){
        if ((username.capitalize()==correctUserName[0])&&(password==correctPassword[0])){
            val intent = Intent(this, StudentHomePage::class.java)
            // calling the intent
            intent.putExtra("fullname",fullNames[0])
            intent.putExtra("id",numberId[0])
            intent.putExtra("course",course[0])
            intent.putExtra("section",sections[0])
            intent.putExtra("sched",schedule[0])
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Welcome $username", Toast.LENGTH_SHORT).show()

        }else if ((username.capitalize()==correctUserName[1])&&(password==correctPassword[1])) {
            val intent = Intent(this, StudentHomePage::class.java)
            // calling the intent
            intent.putExtra("fullname", fullNames[1])
            intent.putExtra("id", numberId[1])
            intent.putExtra("course", course[1])
            intent.putExtra("section", sections[1])
            intent.putExtra("sched", schedule[1])
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Welcome $username", Toast.LENGTH_SHORT).show()
        }else if((password.isBlank())&&(username.isBlank()))
            Toast.makeText(applicationContext, "Please Enter Username and Password", Toast.LENGTH_SHORT).show()
        else if(username.isBlank())
            Toast.makeText(applicationContext, "Userame is missing", Toast.LENGTH_SHORT).show()
        else if(password.isBlank())
            Toast.makeText(applicationContext, "Password is missing", Toast.LENGTH_SHORT).show()

        else
            Toast.makeText(applicationContext, "This Email or Password are not registered", Toast.LENGTH_SHORT).show()


    }

}