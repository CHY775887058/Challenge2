package com.example.chy.challenge.NetInfo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.chy.challenge.Utils.LogUtils;
import com.example.chy.challenge.Utils.NetBaseUtils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 77588 on 2016/9/20.
 */
public class UserRequest {
    private Context mContext;
    private Handler handler;

    public UserRequest(Context mContext, Handler handler) {

        this.mContext = mContext;
        this.handler = handler;
    }
    public void Login(final String phone, final String pwd,final int KEY){
        new Thread() {
            Message msg = Message.obtain();
            public void run() {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("phone",phone));
                params.add(new BasicNameValuePair("password",pwd));
                LogUtils.i("TuiSong", "device_token" + params.toString());
                String result = NetBaseUtils.getResponseForPost(UserNetConstant.NET_USER_LOGIN, params, mContext);
                Log.i("Tip",result);
                msg.what = KEY;
                msg.obj = result;
                handler.sendMessage(msg);
            };
        }.start();
    }

    public void GetCode(final String phone){
        new Thread() {
            Message msg = Message.obtain();
            public void run() {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("phone",phone));
                LogUtils.i("TuiSong", "device_token" + params.toString());
                String result = NetBaseUtils.getResponseForPost(UserNetConstant.NET_USER_LOGIN, params, mContext);
                Log.i("Tip",result);
//                msg.what = KEY;
                msg.obj = result;
                handler.sendMessage(msg);
            };
        }.start();

    }
}
