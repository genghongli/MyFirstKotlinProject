package com.example.administrator.myfirstkotlinproject.activity

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.administrator.myfirstkotlinproject.R
import com.example.administrator.myfirstkotlinproject.adapter.ItemBookTypeAdapter
import kotlinx.android.synthetic.main.activity_all_book.*
import kotlinx.android.synthetic.main.item_title.*


class AllBookActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_book)

        var context:Context = this;
        var title:String = this.intent.getStringExtra("title");

        xt_title.text = title;
        btn_back.setOnClickListener { view: View? ->
            finish();
        }

        var itemBookTypeList:List<String> = arrayListOf("冬令营","博物馆课","营地课程","Max");
        var itemBookTypeAdapter:ItemBookTypeAdapter = ItemBookTypeAdapter(itemBookTypeList,context);
        lv_itembooktype.adapter = itemBookTypeAdapter;

        lv_itembooktype.setOnItemClickListener { adapterView, view, i, l ->
            itemBookTypeAdapter.updateadapter(i,lv_itembooktype);
        }


    }
}
