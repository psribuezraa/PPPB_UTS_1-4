package com.example.layout_uts

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layout_uts.databinding.ActivitySecondBinding

class activity_second : AppCompatActivity() {

    private val TAG = "SECOND_ACTIVITY"
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding){
            btnSubmit.setOnClickListener{
                val intentToMainActivity =
                    Intent(this@activity_second, MainActivity::class.java)
                intentToMainActivity.putExtra("EXTRA_NAME", inputName.text.toString())
                startActivity(intentToMainActivity)
            }
        }





    }
}