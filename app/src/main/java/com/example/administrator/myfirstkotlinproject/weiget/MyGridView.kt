package com.example.administrator.myfirstkotlinproject.weiget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.GridView

class MyGridView : GridView
{

    constructor(mContext: Context) : this(mContext,null)

    constructor(mContext: Context, attrs: AttributeSet?) : this(mContext, attrs!!,0)

    constructor(mContext: Context, attrs: AttributeSet,defStyleAttr:Int) : super(mContext, attrs,defStyleAttr) {
//        init(mContext, attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

       /* int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);*/

       var expandSpec =  MeasureSpec.makeMeasureSpec(Int.MAX_VALUE,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec)
    }

}