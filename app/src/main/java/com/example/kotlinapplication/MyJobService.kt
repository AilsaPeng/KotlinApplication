package com.example.kotlinapplication

import android.annotation.TargetApi
import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import android.util.Log

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class MyJobService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("pengqian", "onStartJob")
        Thread(Runnable {
            Thread.sleep(30000)
//            jobFinished(params, false)
            Log.d("pengqian", "jobFinished")
        }).start()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("pengqian", "onStopJob")
        return true
    }

}