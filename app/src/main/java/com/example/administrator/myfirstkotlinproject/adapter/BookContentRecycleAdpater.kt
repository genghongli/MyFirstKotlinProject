package com.example.administrator.myfirstkotlinproject.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.administrator.myfirstkotlinproject.Bean.BookContentBean
import com.example.administrator.myfirstkotlinproject.R
import com.example.administrator.myfirstkotlinproject.abstracts.RecycleItemClick
import com.example.administrator.myfirstkotlinproject.activity.AllBookActivity
import com.example.administrator.myfirstkotlinproject.activity.BookDetailActivity
import javax.security.auth.callback.Callback

class BookContentRecycleAdpater(var context:Context,var bookContentList:ArrayList<BookContentBean>,var callback:MyCallback):RecyclerView.Adapter<BookContentRecycleAdpater.MyViewHolder>()
{


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var bookname = bookContentList[position].bookname.toString();
        holder.xt_title.text = bookname;
        holder.xt_price.text = bookContentList[position].bookprice.toString();
        holder.ll_container.setOnClickListener {
            var intent = Intent(context, BookDetailActivity::class.java);
            intent.putExtra("bookname",bookContentList[position].bookname);
            context?.startActivity(intent)
        }
        holder.shopcar.setOnClickListener {
            Log.e("tag","购物车"+position.toString())
            callback.click(bookname);

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
        var xt_title = itemView.findViewById<TextView>(R.id.xt_title);
        var xt_price = itemView.findViewById<TextView>(R.id.xt_price);
        var ll_container = itemView.findViewById<LinearLayout>(R.id.ll_container);
        var shopcar = itemView.findViewById<ImageView>(R.id.shopcar);

    }


}

interface  MyCallback {

     fun click(bookname:String)
}




