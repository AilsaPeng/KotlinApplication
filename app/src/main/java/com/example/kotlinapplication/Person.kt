package com.example.kotlinapplication

import android.util.Log

data class Person constructor(var name: String) {
    lateinit var myName: String

    constructor(name: String = "pengqian", sex: String = "girl") : this(name) {
        Log.d("pengqian", "name is $name, sex is $sex")
        myName = name
    }

    fun call(name: String = "pengqian", sex: String) {
        Log.d("pengqian", "name is $name, sex is $sex")
    }
}