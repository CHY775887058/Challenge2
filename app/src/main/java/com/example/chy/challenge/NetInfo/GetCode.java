package com.example.chy.challenge.NetInfo;

import android.content.Context;
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
public class GetCode {
    private String phone;
    String code = "false";
    public int Key = 11;
    public String GetCode(final String phone, final Context mContext) {
        this.phone = phone;
        new Thread() {
            Message msg = Message.obtain();
            public void run() {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("phone",phone));
                LogUtils.i("TuiSong", "device_token" + params.toString());
                String result = NetBaseUtils.getResponseForPost(UserNetConstant.NET_USER_CODE, params, mContext);
                Log.i("Tip",result);
                if (result!=null){
                    code = result;
                }
            };
        }.start();
        return code;
    }

}
