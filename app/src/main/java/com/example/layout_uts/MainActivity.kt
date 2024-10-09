package com.example.layout_uts

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layout_uts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MAIN_ACTIVITY"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            txtUsername.text = name
        }
        val name = intent.getStringExtra("EXTRA_NAME")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnMoveToActivitySecond.setOnClickListener{
            val intent = Intent(this, activity_second::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnKeluar.setOnClickListener{
            val intent = Intent(this, activity_third::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this, "You have successfully logged out", Toast.LENGTH_SHORT).show()
        }
    }
}