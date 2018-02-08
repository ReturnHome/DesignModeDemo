package com.weconex.designmodedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.weconex.designmodedemo.R;
import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.CircleShape;
import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.GifReaderFactory;
import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.JpgReaderFactory;
import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.PngReaderFactory;
import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.RectShape;
import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.ShapeFactory;
import com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式.TriangleShape;

/**
 * Created by lifeng on 2018/1/31.
 *
 * @desc 工厂类模式
 */

public class FactoryActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.Button clickBtn1;
    private android.widget.Button clickBtn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
        this.clickBtn1 = (Button) findViewById(R.id.clickBtn1);
        this.clickBtn2 = (Button) findViewById(R.id.clickBtn2);

        clickBtn1.setOnClickListener(this);
        clickBtn2.setOnClickListener(this);
    }

    private int number = 0;

    @Override
    public void onClick(View v) {
        if (number > 2) {
            number = 0;
        }
        switch (v.getId()) {
            case R.id.clickBtn1:
//                ShapeFactory.getShape(number + "");
                CircleShape circleShape = (CircleShape) ShapeFactory.getShape1(CircleShape.class);
                circleShape.draw();
                RectShape rectShape = (RectShape) ShapeFactory.getShape1(RectShape.class);
                rectShape.draw();
                TriangleShape triangleShape = (TriangleShape) ShapeFactory.getShape1(TriangleShape.class);
                triangleShape.draw();
                break;
            case R.id.clickBtn2:
                switch (number) {
                    case 0:
                        JpgReaderFactory jpgReaderFactory = new JpgReaderFactory();
                        jpgReaderFactory.getReader().read();
                        break;
                    case 1:
                        new PngReaderFactory().getReader().read();
                        break;
                    case 2:
                        new GifReaderFactory().getReader().read();
                        break;
                }
                break;
        }
        number++;
    }
}
