package com.example.kthw2_3

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件")

            dialog.setNeutralButton("取消") { _, _ ->
                Toast.makeText(this, "dialog關閉", Toast.LENGTH_SHORT).show()
            }

            dialog.setNegativeButton("自定義Toast") { _, _ ->
                showToast()
            }

            dialog.setPositiveButton("顯示list") { _, _ ->
                showListDialog()
            }
            dialog.show()
        }
    }

    private fun showToast() {
        val toast = Toast(this)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        val inflater: LayoutInflater = layoutInflater
        val layout: View = inflater.inflate(R.layout.custom_toast, findViewById<ViewGroup>(R.id.custom_toast_root))
        toast.view = layout
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialogList = AlertDialog.Builder(this)
        dialogList.setTitle("使用LIST呈現")
        dialogList.setItems(list) { _, i ->
            Toast.makeText(this, "你選的是" + list[i], Toast.LENGTH_SHORT).show()
        }
        dialogList.show()
    }
}
