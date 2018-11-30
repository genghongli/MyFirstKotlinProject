package com.example.administrator.myfirstkotlinproject.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.administrator.myfirstkotlinproject.R

class BookTypeAdapter(val contentlist:List<String>,val context:Context):BaseAdapter()
{
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var viewholder:ViewHolder_booktype ?= null ;
        var view:View;
        if(p1 == null)
        {
            view = View.inflate(context,R.layout.item_booktype,null);
            viewholder = ViewHolder_booktype(view);
            view.tag = viewholder;
        }
        else
        {
            view = p1;
            viewholder = view.tag as ViewHolder_booktype;
        }

        var textitemset = contentlist[p0];

        viewholder.item_text.text = textitemset;
        return view;





    }

    override fun getItem(p0: Int): Any {
        return contentlist.get(p0);
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getCount(): Int {
        return contentlist.size;
    }



}

class ViewHolder_booktype (var view: View){

    var item_text = view.findViewById<TextView>(R.id.item_text);
}
