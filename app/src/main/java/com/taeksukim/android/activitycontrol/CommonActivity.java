package com.taeksukim.android.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CommonActivity extends AppCompatActivity {


    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        tv = (TextView) findViewById(R.id.textView4);
        //1.  Intent 꺼내기
        Intent intent = getIntent();
        //2. Intent에서 Extra 꾸러미(bundle)꺼내기
        Bundle bundle = intent.getExtras();
        //3. bundle에서 변수(타입에 맞게) 직접 꺼내기
        String string = bundle.getString("var");

        tv.setText(string);

    }


}


