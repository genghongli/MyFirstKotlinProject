package com.example.administrator.myfirstkotlinproject

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.text.TextUtils.replace
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.administrator.myfirstkotlinproject.R.id.add
import com.example.administrator.myfirstkotlinproject.fragment.BuyCarFragment
import com.example.administrator.myfirstkotlinproject.fragment.HomeFragment
import com.example.administrator.myfirstkotlinproject.fragment.ShopInfoFragment
import com.example.administrator.myfirstkotlinproject.fragment.UserFragment

//import com.example.administrator.myfirstkotlinproject.*
import kotlinx.android.synthetic.main.activity_main.*

//import com.example.administrator.myfirstkotlinproject.activity_main.*;

class MainActivity : FragmentActivity() {

    val tag = "tag";

    val homeFragment:HomeFragment = HomeFragment();
     var currentFragment:Fragment = homeFragment;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //findViewById<Button>(R.id.button).setOnClickListener(this);

//        button.text = "哈哈";
//        button.setOnClickListener { view ->
//            val id = view.id;
//            Log.e(tag,id.toString()+button.text);
//        }


//        *//*var a = "123456>78";
////        var b = a.trimMargin(">");
////        Log.e("tag",b);
////        println(b);
////
////        val num = -1;
////        if(num in (0..10))
////        {
////            Log.e(tag,"num在范围内");
////        }
////
////        var age:String ?= "0";
////        Log.e(tag,"age------"+age);*//*
////
////        *//*var a = "test";
////        val b = "my name is $a";
////        Log.e(tag,b);
////
////        var c = "${b.replace("name","age")},but now is $a";
////        Log.e(tag,c);*//*
////
//////        "===" 判断对象地址  "=="判断数值大小
////
////
//////        val c = """;
//////        val a = "123456 78";
//////        val c = " ";
//////        val b = a.trimMargin();
//////        Log.e(tag,b);
////
////        //创建集合
////        *//* val a = arrayListOf<Int>(1,2,3,4,5,6,7);
//////        for (b in a.indices)
//////        {
//////            Log.e(tag, b.toString());
//////        }
////
////        for (b:Int in a)
////        {
////            Log.e(tag, b.toString());
////        }*//*
////
////        *//*var items = listOf<String>("apple","arange","pear");
////        for (item in items.indices)
////        {
////            Log.e(tag,item.toString());
////        }*//*
////
////        *//*val a = 1;
////        val b = 2;
////        loop@ for (a in (1..10))
////        {
////            Log.e(tag,"a-----"+a);
////            for (b in (1..10))
////            {
////                Log.e(tag,"b-----"+b);
////                if(b == 2)
////                {
////                    break@loop;
////                }
////            }
////        }*//*
////
////        *//* val person:Person= Person();
////        person.name="zhang";
////        var c = person.name;
////        Log.e(tag,c);*//*
////
////        val student:Student = Student();
////        student.fatherclazz();*/



        val homeFragment:HomeFragment = HomeFragment();
        addFragment(homeFragment,R.id.fragment);
        currentFragment = homeFragment;



       ll_home.setOnClickListener { view ->

           val homeFragment:HomeFragment = HomeFragment();
           createFragment(homeFragment)

       }
        ll_shopinfo.setOnClickListener { view: View? ->
            val shopInfoFragment:ShopInfoFragment = ShopInfoFragment();
            createFragment(shopInfoFragment);
        }
        ll_buycar.setOnClickListener { view: View? ->
            val buyCarFragment:BuyCarFragment = BuyCarFragment();
            createFragment(buyCarFragment);
        }
        ll_user.setOnClickListener { view: View? ->
            val userFragment:UserFragment = UserFragment();
            createFragment(userFragment);
        }






    }

    fun createFragment (clickfragment:Fragment)
    {
        Log.e("tag",clickfragment.toString());
        if(clickfragment != currentFragment)
        {
            currentFragment = clickfragment;
            replaceFragment(clickfragment,R.id.fragment);
        }

    }



    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }
    fun FragmentActivity.addFragment(fragment: Fragment, frameId: Int){
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }


    fun FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction{replace(frameId, fragment)}
    }





}



