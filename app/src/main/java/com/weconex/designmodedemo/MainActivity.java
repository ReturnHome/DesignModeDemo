package com.weconex.designmodedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.AbstractFactory;
import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.FactoryProduct;
import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.Shape;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerId(R.id.btn1);
        registerId(R.id.btn2);
    }

    private void registerId(int id){
        findViewById(id).setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    startActivity(new Intent(MainActivity.this, FactoryActivity.class));
                    break;
                case R.id.btn2:
                    //通过工厂生成器  生成工厂对象
                    //通过传递不同的类型  创建不同的工厂对象
                    AbstractFactory shape = FactoryProduct.getFactory("shape");
                    //通过类型  创建不同的产品
                    Shape shape1 = shape.getShape(0);
                    //调用产品里面的方法
                    shape1.draw();
                    break;
            }
        }
    };
}
