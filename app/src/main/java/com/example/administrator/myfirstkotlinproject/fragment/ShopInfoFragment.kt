package com.example.administrator.myfirstkotlinproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.myfirstkotlinproject.R

class ShopInfoFragment: Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_shopinfo,container,false);

        return view;
    }
}