package com.example.formvalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.basgeekball.awesomevalidation.utility.RegexTemplate
import com.example.formvalidation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var awesomeValidation:AwesomeValidation
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        awesomeValidation= AwesomeValidation(ValidationStyle.BASIC)
        awesomeValidation.addValidation(this,R.id.et_name,RegexTemplate.NOT_EMPTY,R.string.invalid_name)
        awesomeValidation.addValidation(this,R.id.et_mobile,"[5-9]{1}[0-9]{9}$",R.string.invalid_mobile)
        awesomeValidation.addValidation(this,R.id.et_email,Patterns.EMAIL_ADDRESS,R.string.invalid_email)
        awesomeValidation.addValidation(this,R.id.et_website,Patterns.WEB_URL,R.string.invalid_website)
        awesomeValidation.addValidation(this,R.id.et_password,".{6,}",R.string.invalid_password)
        awesomeValidation.addValidation(this,R.id.et_confirm_password,R.id.et_password,R.string.invalid_confirm_password)
        binding.btnSubmit.setOnClickListener {
            if(awesomeValidation.validate())
            { Toast.makeText(applicationContext,"Form Validate Successfully",Toast.LENGTH_SHORT).show() }
            else{ Toast.makeText(applicationContext,"Validation Failed",Toast.LENGTH_SHORT).show() }
        }
    }
}