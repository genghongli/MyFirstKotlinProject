package com.example.administrator.myfirstkotlinproject.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

class ViewPageAdapter(val context: Context,val pagelist:List<View>):PagerAdapter()
{
    override fun getCount(): Int {
        return pagelist.size
    }
    override fun isViewFromObject(view: View, objects: Any): Boolean {
        return view == objects;
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {


        container.addView(pagelist[position] );
        return pagelist[position];

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        var view = `object`;
        container.removeView(view as View);
    }


}