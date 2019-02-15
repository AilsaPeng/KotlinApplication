package com.example.kotlinapplication

import android.app.job.JobInfo
import android.app.job.JobInfo.*
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    val jobId = 1000
    val Person.lastName: String
        get() {
            return this.name
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text.text = "first kotlin demo!"
        action.setOnClickListener {
            Toast.makeText(this, "you click the button", LENGTH_LONG).show()
            var person = Person("pengqianhaha")
            text.text = person.lastName
            var jobInfo = JobInfo.Builder(jobId, ComponentName(this, MyJobService::class.java))
//                    .setMinimumLatency(3000)
//                    .setPeriodic(5000)
                    .setRequiredNetworkType(NETWORK_TYPE_ANY)
                    .setBackoffCriteria(3000, BACKOFF_POLICY_LINEAR)
                    .build()
            (getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler).schedule(jobInfo)
        }
        Log.d("pengqian", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        (getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler).cancel(jobId)
//        jobScheduler?.cancel(jobId)
//        jobScheduler.cancelAll()
        Log.d("pengqian", "onDestroy")
    }
}
