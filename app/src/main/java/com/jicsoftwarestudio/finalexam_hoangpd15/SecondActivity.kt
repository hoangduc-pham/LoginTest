package com.jicsoftwarestudio.finalexam_hoangpd15

import android.app.AlertDialog
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jicsoftwarestudio.finalexam_hoangpd15.databinding.ActivitySecondBinding
import kotlinx.coroutines.delay

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var myService: MyService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("SecondActivity", "onCreate")
        binding.buttonStartService.setOnClickListener {
            startMyService()
        }
        binding.buttonStartService2.setOnClickListener {
            startMyService()
        }
        binding.buttonStartService3.setOnClickListener {
            startMyService()
        }
        binding.buttonStartService4.setOnClickListener {
            startMyService()
        }
        binding.buttonStartService5.setOnClickListener {
            startMyService()
        }
        binding.buttonStartService6.setOnClickListener {
            startMyService()
        }
        binding.buttonStartService7.setOnClickListener {
            startMyService()
        }
        binding.buttonStartService8.setOnClickListener {
            startMyService()
        }
        binding.buttonStartService9.setOnClickListener {
            startMyService()
        }
    }

    private fun startMyService() {
        val serviceIntent = Intent(this, MyService::class.java)
        startService(serviceIntent)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
    override fun onDestroy() {
        super.onDestroy()
        showDestroyDialog()
    }
    private fun showDestroyDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Activity Destroyed")
        builder.setMessage("SecondActivity is being destroyed.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}