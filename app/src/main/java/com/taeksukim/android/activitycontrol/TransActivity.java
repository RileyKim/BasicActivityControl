package com.taeksukim.android.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TransActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button btnOK;
    TextView tvValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);

        editText = (EditText) findViewById(R.id.editText);

        btnOK = (Button) findViewById(R.id.btnOK);
        tvValue = (TextView)  findViewById(R.id.textView3);

        btnOK.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        //1. 되돌려 줄 값을 설정
        String result = editText.getText().toString();
        //2. 처리 상태를 설정
        int statusCode = 0;
        // 3. 되돌려 줄 값이 문제가 있으면 처리상태 변경
        if(result == null || result.equals("")) {
            statusCode = 0;
        }
        //4. 돌려줄 값을 Intent에 세팅
        intent.putExtra("result", result);
        //5. setResult 함수로 결과값 전송
        setResult(statusCode, intent);
        //6. 액티비티를 종료하여 메인 액티비티를 화면에 나타낸다.
        finish();
    }

}
