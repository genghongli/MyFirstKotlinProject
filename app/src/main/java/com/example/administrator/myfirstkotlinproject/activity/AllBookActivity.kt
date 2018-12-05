package com.example.administrator.myfirstkotlinproject.activity

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.AdapterView
import com.example.administrator.myfirstkotlinproject.Bean.BookContentBean
import com.example.administrator.myfirstkotlinproject.R
import com.example.administrator.myfirstkotlinproject.abstracts.RecycleItemClick
import com.example.administrator.myfirstkotlinproject.adapter.BookContentRecycleAdpater
import com.example.administrator.myfirstkotlinproject.adapter.ItemBookTypeAdapter
import com.example.administrator.myfirstkotlinproject.adapter.MyCallback
import com.example.administrator.myfirstkotlinproject.weiget.Shopwindow
import kotlinx.android.synthetic.main.activity_all_book.*
import kotlinx.android.synthetic.main.item_title.*


class AllBookActivity : Activity() {

    var shopwindow:Shopwindow = Shopwindow();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_book)

        var context:Context = this;
        var title:String = this.intent.getStringExtra("title");

        xt_title.text = title;
        btn_back.setOnClickListener { view: View? ->
            finish();
        }

        var itemBookTypeList = listOf<String>("冬令营","博物馆课","营地课程","Max");
        var itemBookTypeAdapter:ItemBookTypeAdapter = ItemBookTypeAdapter(itemBookTypeList,context);
        lv_itembooktype.adapter = itemBookTypeAdapter;

        lv_itembooktype.setOnItemClickListener { adapterView, view, i, l ->
            itemBookTypeAdapter.updateadapter(i,lv_itembooktype);
        }


        var bookContentList = ArrayList<BookContentBean>();
        for ( i in 0..2)
        {

            var imageResource:Int = R.drawable.f1;
            var bookname:String = "冬令营|跟大师学画画1111"+i.toString();
            var bookprice:Double = 2659.00;
            var bookContentBean:BookContentBean = BookContentBean(imageResource,bookname,bookprice);
            bookContentList.add(bookContentBean);

        }

       //var callback:MyCallback = MyCallback();

        var bookContentRecycleAdpater:BookContentRecycleAdpater = BookContentRecycleAdpater(context,bookContentList,object :MyCallback{
            override fun click(bookname:String)
            {
                Log.e("tag",bookname)

                shopwindow.showWindow(context,ll_container,bookname)
            }
        });
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter = bookContentRecycleAdpater;

        swipRefreshLayout.setColorSchemeColors(Color.BLUE);
        swipRefreshLayout.setOnRefreshListener {


            for ( i in 0..1)
            {
                "123".toInt();
                var imageResource:Int = R.drawable.f1;
                var bookname:String = "冬令营|跟大师学画画1111"+i.toString();
                var bookprice:Double = 2659.00;
                var bookContentBean:BookContentBean = BookContentBean(imageResource,bookname,bookprice);
                bookContentList.add(bookContentBean);

            }

            swipRefreshLayout.isRefreshing = false;
            bookContentRecycleAdpater.notifyDataSetChanged()

        }


    }

    override fun onDestroy() {
        super.onDestroy()

        shopwindow.disWindow()
    }
}


