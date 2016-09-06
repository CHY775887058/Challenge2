package com.example.chy.challenge.Adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chy.challenge.R;

import java.util.List;

/**
 * Created by 77588 on 2016/9/3.
 */
public class OptionsAdepter extends ArrayAdapter<Options>{
    private int resourceId;
    public OptionsAdepter(Context context, int textViewResourceId, List<Options> objects) {
        super(context, textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Options options = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.optionImage = (ImageView) view.findViewById(R.id.option_image);
            viewHolder.optitionName = (TextView) view.findViewById(R.id.option_name);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.optionImage.setImageResource(options.getImageId());
        viewHolder.optitionName.setText(options.getOptionsName());
        return view;
    }

    class  ViewHolder{
        ImageView optionImage;
        TextView optitionName;
    }

}
