package com.jicsoftwarestudio.finalexam_hoangpd15

import android.app.AlertDialog
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import kotlinx.coroutines.*

class MyService : Service() {
    private val handler = Handler(Looper.getMainLooper())
    private val binder = MyBinder()

    inner class MyBinder : Binder() {
        fun getService(): MyService = this@MyService
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "Start Service")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "Service started")

        // Execute long running task in a background thread
        Thread {
            val sum = sumFrom1To1000000()
            Log.d("MyService", "Sum from 1 to 1000000")
            handler.postDelayed({
                Log.d("MyService", "Task completed after 5 seconds delay")
                stopSelf()
            }, 5000)
        }.start()
        return START_STICKY
    }

    private fun sumFrom1To1000000(): Long {
        var sum = 0L
        for (i in 1..1000000) {
            sum += i
        }
        return sum
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "Service destroyed")
    }
}
