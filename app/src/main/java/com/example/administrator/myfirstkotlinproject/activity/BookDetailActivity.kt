package com.example.administrator.myfirstkotlinproject.activity

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.administrator.myfirstkotlinproject.R
import com.example.administrator.myfirstkotlinproject.adapter.ViewPageAdapter
import kotlinx.android.synthetic.main.activity_book_detail.*
import kotlinx.android.synthetic.main.item_title.*

class BookDetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val context: Context? = this;

        val bookname = intent.getStringExtra("bookname");
        //轮播
        val page01 = View.inflate(context,R.layout.page01,null);
        val page02 = View.inflate(context,R.layout.page02,null);
        val page03 = View.inflate(context,R.layout.page03,null);
        val viewpagedata = arrayListOf<View>(page01,page02,page03);
        var viewPagerAdapter: ViewPageAdapter = ViewPageAdapter(context!!,viewpagedata);
        viewpager.adapter = viewPagerAdapter;

        xt_title.text = "商品详情";
        btn_back.setOnClickListener { View->
            finish();
        }

        xt_bookname.text = bookname;




    }
}

