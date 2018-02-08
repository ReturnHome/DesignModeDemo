package com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式;

/**
 * Created by lifeng on 2018/1/31.
 */

public class GifReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new GifReader();
    }
}
