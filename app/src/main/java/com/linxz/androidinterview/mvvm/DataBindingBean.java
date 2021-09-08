package com.linxz.androidinterview.mvvm;

import androidx.databinding.BaseObservable;

/**
 * @author Linxz
 * 创建日期：2021年07月20日 9:23 AM
 * version：
 * 描述：
 */
public class DataBindingBean extends BaseObservable {
    private String userName;
    private String avatar;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyChange();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
