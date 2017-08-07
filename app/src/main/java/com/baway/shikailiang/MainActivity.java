package com.baway.shikailiang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyView mv = (MyView) findViewById(R.id.myView);
        mv.setOnChlicks(new MyView.OnChlick() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"点击了返回",Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this,"点击了更多",Toast.LENGTH_LONG).show();
            }
        });
    }
}
