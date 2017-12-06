package com.pcitech.fnetserver;

import android.app.Application;

import cn.hotapk.fastandrutils.utils.FUtils;

/**
 * @author laijian
 * @version 2017/12/1
 * @Copyright (C)上午11:40 , www.hotapk.cn
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FUtils.init(this);
    }
}
