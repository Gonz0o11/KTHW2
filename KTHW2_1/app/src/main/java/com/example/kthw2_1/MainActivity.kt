package com.example.kthw2_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvMeal: TextView
    private lateinit var btnSelect: Button

    private val mStartForResult: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val intent = result.data

                intent?.extras?.let { bundle ->
                    val str1 = bundle.getString("drink")
                    val str2 = bundle.getString("sugar")
                    val str3 = bundle.getString("ice")
                    tvMeal.text = "飲料: $str1\n\n甜度: $str2\n\n冰塊: $str3\n\n"
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMeal = findViewById(R.id.tv_meal)
        btnSelect = findViewById(R.id.btn_choice)

        btnSelect.setOnClickListener {
            mStartForResult.launch(Intent(this, MainActivity2::class.java))
        }
    }
}