package com.example.administrator.myfirstkotlinproject.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.transition.Visibility
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.administrator.myfirstkotlinproject.R
import java.text.FieldPosition

class ItemBookTypeAdapter(val contentlist:List<String>,val context:Context):BaseAdapter()
{
    var tag:Int = 0;
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

    fun updateadapter(position: Int, listView: ListView)
    {
        /*int visiblePosition = listview.getFirstVisiblePosition();
        //得到指定位置的视图，对listview的缓存机制不清楚的可以去了解下
        View view = listview.getChildAt(index - visiblePosition);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tv2 = (TextView) view.findViewById(R.id.tv2);*/

        //tag = position;
        var oldview = listView.getChildAt(tag);
        var holder_old = oldview.tag as ViewHolder_itembooktype;
        holder_old.line.visibility = View.GONE;

        var visiblePosition = listView.firstVisiblePosition;
        var view = listView.getChildAt(position - visiblePosition);
        var holder = view.tag as ViewHolder_itembooktype;
        holder.line.visibility = View.VISIBLE;
        tag = position;
//        holder.item_text?.textColors(context.getColor(R.color.red));
    }



}


class ViewHolder_itembooktype (var view: View){

    var item_text = view.findViewById<TextView>(R.id.item_text);
    var line = view.findViewById<View>(R.id.line);
}
