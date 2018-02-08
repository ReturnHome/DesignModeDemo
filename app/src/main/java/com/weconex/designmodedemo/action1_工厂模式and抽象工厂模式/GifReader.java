package com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式;

import android.util.Log;

/**
 * Created by lifeng on 2018/1/31.
 */

public class GifReader implements Reader {
    @Override
    public void read() {
        Log.i("TAG", "GifReader:read");
    }
}
