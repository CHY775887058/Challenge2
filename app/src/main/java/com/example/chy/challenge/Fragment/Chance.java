package com.example.chy.challenge.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chy.challenge.Adepter.Detail_Adepter;
import com.example.chy.challenge.R;
import com.example.chy.challenge.pnlllist.PullToRefreshBase;
import com.example.chy.challenge.pnlllist.PullToRefreshListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 77588 on 2016/9/1.
 */
public class Chance extends Fragment {
    private Detail_Adepter detail_adepter;
    private Context mcontext;
    private List<String> list;

    private SimpleDateFormat mdata = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private View viewH = null;
    private ListView lv_view;

    private TextView detail_loading;
    private PullToRefreshListView pulllist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chance,container,false);

        mcontext = getActivity();
        list = new ArrayList<>();

        pulllist = (PullToRefreshListView) view.findViewById(R.id.lv_comprehensive);
        //设置下拉活动
        pulllist.setPullLoadEnabled(true);
        pulllist.setScrollLoadEnabled(false);

        pulllist.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
//                initData();
//                stopRefresh();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
//                stopRefresh();
            }
        });


        //获取当前时间
        setLastData();

        //自动刷新，500毫秒
//        pulllist.doPullRefreshing(true, 500);

    //设置pulllistview
        lv_view = pulllist.getRefreshableView();
    for (int i = 0;i<10;i++){
        list.add(String.valueOf(i));
    }
        detail_adepter = new Detail_Adepter(list,mcontext,0);
        lv_view.setAdapter(detail_adepter);

        //添加头部信息
//        viewH = LayoutInflater.from(getActivity()).inflate(R.layout.firstpagenew, null);
//        lv_view.addHeaderView(viewH);


        return view;
    }

    //获取当前时间
    private void setLastData() {
        String text = formatdatatime(System.currentTimeMillis());
        pulllist.setLastUpdatedLabel(text);
        Log.i("time", "-------->" + text);
    }
    //停止刷新
    private void stopRefresh() {
        pulllist.postDelayed(new Runnable() {
            @Override
            public void run() {
                pulllist.onPullUpRefreshComplete();
                pulllist.onPullDownRefreshComplete();
                setLastData();
            }
        }, 2000);
    }
    private String formatdatatime(long time){
        if (0==time){
            return "";
        }
        return mdata.format(new Date(time));
    }
}
