package com.baway.shikailiang;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/7.
 */

public class MyView extends RelativeLayout {

    private String left_text;
    private String center_text;
    private String right_text;
    private int leftcolor;
    private int centercolor;
    private int rightcolor;
    private int leftbgcolor;
    private int centerbgcolor;
    private int rightbgcolor;
    private int leftsize;
    private int centersize;
    private int rightsize;
    private TextView left_texts;
    private TextView center_texts;
    private TextView right_texts;
    private OnChlick onChlick;
    public void setOnChlicks(OnChlick onChlick){
        this.onChlick = onChlick;
    }
    public MyView(Context context) {
        super(context);
        initView(null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Myattrs);
        //文字得内容
        left_text = typedArray.getString(R.styleable.Myattrs_left_text);
        center_text = typedArray.getString(R.styleable.Myattrs_center_text);
        right_text = typedArray.getString(R.styleable.Myattrs_right_text);
        //文字得颜色
        leftcolor = typedArray.getColor(R.styleable.Myattrs_left_color, Color.BLUE);
        centercolor = typedArray.getColor(R.styleable.Myattrs_center_color, Color.BLUE);
        rightcolor = typedArray.getColor(R.styleable.Myattrs_right_color, Color.BLUE);
        //文字得背景颜色
        leftbgcolor = typedArray.getColor(R.styleable.Myattrs_left_bgcolor, Color.BLACK);
        centerbgcolor = typedArray.getColor(R.styleable.Myattrs_center_bgcolor, Color.BLACK);
        rightbgcolor = typedArray.getColor(R.styleable.Myattrs_right_bgcolor, Color.BLACK);
        //文字大小
        leftsize = typedArray.getInteger(R.styleable.Myattrs_left_size, 16);
        centersize = typedArray.getInteger(R.styleable.Myattrs_center_size, 16);
        rightsize = typedArray.getInteger(R.styleable.Myattrs_right_size, 16);
        typedArray.recycle();
        initView(attrs);

    }

    private void initView(AttributeSet attrs) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item, this);
        //找到控件id。
        left_texts = (TextView)view.findViewById(R.id.left_text);
        left_texts.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                left_texts.setBackgroundColor(Color.RED);
                onChlick.leftClick();
            }
        });
        center_texts = (TextView)view.findViewById(R.id.center);
        right_texts = (TextView)view.findViewById(R.id.right_text);
        left_texts.setText(left_text);
        left_texts.setTextColor(leftcolor);
        left_texts.setBackgroundColor(leftbgcolor);
        left_texts.setTextSize(leftsize);
        center_texts.setText(center_text);
        center_texts.setTextColor(centercolor);
        center_texts.setBackgroundColor(centerbgcolor);
        center_texts.setTextSize(centersize);
        right_texts.setText(right_text);
        right_texts.setTextColor(rightcolor);
        right_texts.setBackgroundColor(rightbgcolor);
        right_texts.setTextSize(rightsize);
        right_texts.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onChlick.rightClick();
                right_texts.setBackgroundColor(Color.RED);
            }
        });
    }

    interface OnChlick{
        void leftClick();
        void rightClick();
    }
}
