package com.example.administrator.myfirstkotlinproject.adapter

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
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

        viewholder.item_text.tag = 0;
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

    fun updateadapter(position: Int, view: View)
    {
        //0是选中 1未选中

        var holder = view.tag as ViewHolder_booktype;
        var texttag = holder.item_text.tag

        when(texttag)
        {
            0->
            {
                holder.item_text.background = context.getDrawable(R.drawable.ovalshape_select)
                //holder.item_text.textColors(context.getColor(R.color.red));
                holder.item_text.tag = 1;

                /*int[] colors = new int[] { Color.parseColor(selected), Color.parseColor(pressed), Color.parseColor(normal) };
                int[][] states = new int[3][];
                states[0] = new int[] { android.R.attr.state_selected};
                states[1] = new int[] { android.R.attr.state_pressed};
                states[2] = new int[] {};
                ColorStateList colorList = new ColorStateList(states, colors);*/



            }
            1->
            {
                holder.item_text.background = context.getDrawable(R.drawable.ovalshape_unselect)
                holder.item_text.tag = 0
            }

        }


    }




}

class ViewHolder_booktype (var view: View){

    var item_text = view.findViewById<TextView>(R.id.item_text);
}
