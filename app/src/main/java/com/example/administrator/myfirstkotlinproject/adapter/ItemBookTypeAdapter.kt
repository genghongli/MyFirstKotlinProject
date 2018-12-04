package com.example.administrator.myfirstkotlinproject.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.support.annotation.RequiresApi
import android.transition.Visibility
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.administrator.myfirstkotlinproject.R
import java.text.FieldPosition

class ItemBookTypeAdapter(val contentlist:List<String>,val context:Context):BaseAdapter()
{
    var tag:Int = 0;
    @RequiresApi(Build.VERSION_CODES.M)
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var viewholder:ViewHolder_itembooktype ?= null ;
        var view:View;
        if(p1 == null)
        {
            view = View.inflate(context,R.layout.item_itembooktype,null);
            viewholder = ViewHolder_itembooktype(view);
            view.tag = viewholder;
        }
        else
        {
            view = p1;
            viewholder = view.tag as ViewHolder_itembooktype;
        }

        if(p0 == 0)
        {
            viewholder.line.visibility = View.VISIBLE;
        }

        //var colorStateList:ColorStateList = arrayListOf<ColorStateList>(context.getColorStateList(R.color.red))
        var textitemset = contentlist[p0];
        viewholder.item_text.text = textitemset;
        //viewholder.item_text.textColors(colorStateList)

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

    fun updateadapter(position: Int, listView: ListView)
    {
        var viewCount = listView.count-1;
        for (i in 0..viewCount)
        {

            var view = listView.getChildAt(i);
            var holder = view.tag as ViewHolder_itembooktype;
            if(i == position)
            {
                holder.line.visibility = View.VISIBLE;
            }
            else
            {
                holder.line.visibility = View.GONE;
            }
        }

    }
}


class ViewHolder_itembooktype (var view: View){

    var item_text = view.findViewById<TextView>(R.id.item_text);
    var line = view.findViewById<View>(R.id.line);
}
