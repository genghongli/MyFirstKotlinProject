package com.example.administrator.myfirstkotlinproject.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.administrator.myfirstkotlinproject.R

class ContentAdapter(val imagelist:ArrayList<Int>, val contentlist:List<String>,val context:Context):BaseAdapter()
{
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var viewholder:ViewHolder ?= null ;
        var view:View;
        if(p1 == null)
        {
            view = View.inflate(context,R.layout.item_content,null);
            viewholder = ViewHolder(view);
            view.tag = viewholder;
        }
        else
        {
            view = p1;
            viewholder = view.tag as ViewHolder;
        }

        //var item = getItem(p0);
        var imageitemset = imagelist[p0];
        var textitemset = contentlist[p0];

        viewholder.item_text.text = textitemset;
        viewholder.item_image.setBackgroundResource(imageitemset);
        return view;





    }

    override fun getItem(p0: Int): Any {
        return imagelist.get(p0);
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getCount(): Int {
        return imagelist.size;
    }



}

class ViewHolder (var view: View){

    var item_image = view.findViewById<ImageView>(R.id.item_image);
    var item_text = view.findViewById<TextView>(R.id.item_text);
}
