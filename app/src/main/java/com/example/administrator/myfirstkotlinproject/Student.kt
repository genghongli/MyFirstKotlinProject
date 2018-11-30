package com.example.administrator.myfirstkotlinproject

import android.util.Log

class Student:Person()
{
    override fun fatherclazz()
    {
        Log.e("tag","我是子类");
    }
}