package com.example.chy.challenge.Adepter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chy.challenge.R;

import java.util.List;

/**
 * Created by 77588 on 2016/9/8.
 */
public class Detail_Adepter extends BaseAdapter{
    private List<String> list;
    private Context context;
    private int type;

    public Detail_Adepter(List<String> list, Context context,int type) {
        this.list = list;
        this.context = context;
        this.type = type;
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int i) {

        return list.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommonViewHolder commonViewHolder = null;

        if (view == null){
            view = View.inflate(context, R.layout.detail_adepter,null);
            commonViewHolder = new CommonViewHolder();
            commonViewHolder.textView = (TextView) view.findViewById(R.id.position);
            view.setTag(commonViewHolder);


        }else {
            commonViewHolder = (CommonViewHolder) view.getTag();
        }
        commonViewHolder.textView.setText(list.get(i));

        return view;
    }
    public static class CommonViewHolder{
        private TextView textView;

    }
}
