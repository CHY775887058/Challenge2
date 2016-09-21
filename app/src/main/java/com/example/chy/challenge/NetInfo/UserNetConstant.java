package com.example.chy.challenge.NetInfo;

/**
 * Created by mac on 16/5/9.
 */
public interface UserNetConstant extends NetBaseConstant {
    /**
     * 登录
     */
    public final static String NET_USER_LOGIN = NET_BASE_HOST + "&a=applogin";
    /**
     * 验证码
     */
    public final static String NET_USER_CODE = NET_BASE_HOST + "&a=SendMobileCode";
}
