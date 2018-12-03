package com.example.administrator.myfirstkotlinproject.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.administrator.myfirstkotlinproject.Bean.BookContentBean
import com.example.administrator.myfirstkotlinproject.R
import com.example.administrator.myfirstkotlinproject.abstracts.RecycleItemClick
import com.example.administrator.myfirstkotlinproject.activity.AllBookActivity
import com.example.administrator.myfirstkotlinproject.activity.BookDetailActivity

class BookContentRecycleAdpater(var context:Context,var bookContentList:ArrayList<BookContentBean>):RecyclerView.Adapter<BookContentRecycleAdpater.MyViewHolder>()
{

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.xt_title.text = bookContentList[position].bookname.toString();
        holder.xt_price.text = bookContentList[position].bookprice.toString();
        holder.ll_container.setOnClickListener {
            var intent = Intent(context, BookDetailActivity::class.java);
            intent.putExtra("bookname",bookContentList[position].bookname);
            context?.startActivity(intent)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_bookcontent, parent, false);
//        view.setOnClickListener(onClick());
        //this.item = itemClick;
        return MyViewHolder(view)
    }



    override fun getItemCount(): Int {

        return bookContentList.size;
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var xt_title = itemView.findViewById<TextView>(R.id.xt_title) as TextView;
        var xt_price = itemView.findViewById<TextView>(R.id.xt_price) as TextView;
        var ll_container = itemView.findViewById<LinearLayout>(R.id.ll_container);
    }



}




