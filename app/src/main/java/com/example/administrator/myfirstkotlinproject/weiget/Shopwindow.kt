package com.example.administrator.myfirstkotlinproject.weiget

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.text.Html
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.example.administrator.myfirstkotlinproject.R

class Shopwindow:PopupWindow()
{

    var selectState = 1;//1第一个 2第二个
    var window = PopupWindow();
    fun showWindow(context: Context,ll_container:LinearLayout,bookname:String)
    {
        if (context == null)
        {
            return;
        }
        var mPopView = LayoutInflater.from(context).inflate(R.layout.pop_shop,null);


        window = PopupWindow(mPopView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        window.setFocusable(false);
        // 实例化一个ColorDrawable颜色为半透明
        //ColorDrawable dw = new ColorDrawable(00000);
        var dw = ColorDrawable(context.resources.getColor(R.color.transparent));
        window.setBackgroundDrawable(dw)
        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.popwindowanim);
        // 在底部显示
        window.showAtLocation(ll_container,Gravity.BOTTOM, 0, 0);

        var img_close = mPopView.findViewById<ImageView>(R.id.img_close);
        var xt_add = mPopView.findViewById<TextView>(R.id.xt_add);
        var xt_result = mPopView.findViewById<TextView>(R.id.xt_result);
        var xt_cut = mPopView.findViewById<TextView>(R.id.xt_cut);
        var xt_bookname = mPopView.findViewById<TextView>(R.id.xt_bookname)

        var xt_20 = mPopView.findViewById<TextView>(R.id.xt_20);
        var xt_40 = mPopView.findViewById<TextView>(R.id.xt_40)

        xt_20.setOnClickListener {
           xt_20.background = context.getDrawable(R.drawable.redshape)
            xt_40.background = context.getDrawable(R.drawable.searchcontentshape)

            var content20 =  "<font color=\"#ffffff\">" + "20课时" + "</font>"
            xt_20.text = Html.fromHtml(content20);

            var content40 =  "<font color=\"#000000\">" + "40课时" + "</font>"
            xt_40.text = Html.fromHtml(content40);


        }

        xt_40.setOnClickListener {
            xt_40.background = context.getDrawable(R.drawable.redshape)
            xt_20.background = context.getDrawable(R.drawable.searchcontentshape)
            var content20 =  "<font color=\"#000000\">" + "20课时" + "</font>"
            xt_20.text = Html.fromHtml(content20);

            var content40 =  "<font color=\"#ffffff\">" + "40课时" + "</font>"
            xt_40.text = Html.fromHtml(content40);
        }

        xt_bookname.text = bookname

        img_close.setOnClickListener {
            disWindow()
        }
        xt_add.setOnClickListener {
            var result = xt_result.text.toString().toInt();
            var newresult = result+1;
            Log.e("tag",newresult.toString())
            xt_result.text = newresult.toString();
        }

        xt_cut.setOnClickListener {
            var result = xt_result.text.toString().toInt();
            var newresult = result-1;
            if(newresult>=0)
            {
                xt_result.text = newresult.toString();
            }

        }



/*
        String content = "<font color=\"#FE6026\">" + data + "</font>"
//然后直接setText()
        TextView tvContent = (TextView) view.findViewById(R.id.tvContent);
        tvContent.setText(Html.fromHtml(content));*/






    }

    fun disWindow()
    {
        if(window != null)
        {
            window.dismiss()
        }
    }

}