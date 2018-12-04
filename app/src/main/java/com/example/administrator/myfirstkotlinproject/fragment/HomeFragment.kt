package com.example.administrator.myfirstkotlinproject.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView
import com.example.administrator.myfirstkotlinproject.R
import com.example.administrator.myfirstkotlinproject.activity.AllBookActivity
import com.example.administrator.myfirstkotlinproject.adapter.BookTypeAdapter
import com.example.administrator.myfirstkotlinproject.adapter.ContentAdapter
import com.example.administrator.myfirstkotlinproject.adapter.ViewPageAdapter
import com.example.administrator.myfirstkotlinproject.weiget.MyGridView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)

        val context: Context? = getContext();
        val view = inflater.inflate(R.layout.fragment_home,container,false);
        val viewpage = view.findViewById<ViewPager>(R.id.viewpager) as ViewPager;
        val gridview = view.findViewById<MyGridView>(R.id.gridview) as GridView;
        val gv_booktype = view.findViewById<GridView>(R.id.gv_booktype) as GridView;

        /*val text = view.findViewById<TextView>(R.id.text) as TextView;
        text.text="哈哈";*/


        //列表
        val imagedata = arrayListOf<Int>(R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,R.drawable.f6,R.drawable.f7,R.drawable.f8);
        val contentdata = arrayListOf<String>("文字小说","经营励志","人文社科","生活杂志","教育考试","绘画艺术","少儿读物","所有分类");
        var contentAdapter:ContentAdapter = ContentAdapter(imagedata,contentdata, context!!);
        gridview.adapter=contentAdapter;



        //轮播
        val page01 = View.inflate(context,R.layout.page01,null);
        val page02 = View.inflate(context,R.layout.page02,null);
        val page03 = View.inflate(context,R.layout.page03,null);
        val viewpagedata = arrayListOf<View>(page01,page02,page03);
        var viewPagerAdapter:ViewPageAdapter = ViewPageAdapter(context,viewpagedata);
        viewpage.adapter = viewPagerAdapter;

        //item选择
        var bookTypeList:List<String> = arrayListOf<String>("新书发售","畅销读物","文学小说","少儿读物","励志生活","教育考试","人文社科","影视绘画","所有宝贝");
        var bookTypeAdapter:BookTypeAdapter = BookTypeAdapter(bookTypeList,context);
        gv_booktype.adapter = bookTypeAdapter;


        gridview.setOnItemClickListener { adapterView, view, i, l ->

            var title:String = contentdata[i];
            var intent = Intent(context, AllBookActivity::class.java);
            intent.putExtra("title",title);
            context?.startActivity(intent)

        }

        gv_booktype.setOnItemClickListener { adapterView, view, i, l ->

            bookTypeAdapter.updateadapter(i,view);

        }

//        viewpage.setOnPageChangeListener(
//
//        )




        return view;
    }


}




