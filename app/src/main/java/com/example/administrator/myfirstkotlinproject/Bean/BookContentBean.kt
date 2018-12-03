package com.example.administrator.myfirstkotlinproject.Bean

import com.example.administrator.myfirstkotlinproject.R

class BookContentBean(var imageResource:Int, var bookname:String, var bookprice:Double)
{
    var imageResource1:Int = R.drawable.f1;
    var bookname1:String = "";
    var bookprice1:Double = 0.0;
    init {
        this.imageResource1 = imageResource;
        this.bookname1 = bookname;
        this.bookprice1 = bookprice;
    }
}