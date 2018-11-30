package com.example.administrator.myfirstkotlinproject

import android.util.Log

open class  Person
{
    var name:String=""
    get() = field.toUpperCase();
    set

    ///var age:Int = 0;

    open fun fatherclazz()
    {
        Log.e("tag","我是父类")
    }
}