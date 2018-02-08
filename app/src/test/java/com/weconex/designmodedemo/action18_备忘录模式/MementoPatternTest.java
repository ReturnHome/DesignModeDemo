package com.weconex.designmodedemo.action18_备忘录模式;

import com.weconex.designmodedemo.action17_中介者模式.MediatorPattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lifeng on 2018/2/7.
 */
public class MementoPatternTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");

    }

    @Test
    public void test1() throws Exception {
        MementoPattern.test();
    }

}