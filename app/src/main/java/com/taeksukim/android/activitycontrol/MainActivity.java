package com.taeksukim.android.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

/**
 * CommonActivity와 TransActivity를 Start하고
 * 콘솔에 출력되는 로그를 관찰하세요
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String Tag = "MainActivity";

    public MainActivity() {

        super();
    }
    Button btnDial;
    Button btnBrowse;
    Button btnSMS;
    TextView tv1, tv2;
    Button mbtn1;
    Button mbtn2,mTrans1, mTrans2;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtn1 = (Button) findViewById(R.id.mCommon);
        mbtn1.setOnClickListener(this);
        mbtn2 = (Button) findViewById(R.id.mTrans);
        mbtn2.setOnClickListener(this);
        mTrans1 = (Button) findViewById(R.id.mTrans1);
        mTrans1.setOnClickListener(this);
        mTrans2 = (Button) findViewById(R.id.mTrans2);
        mTrans2.setOnClickListener(this);

        btnDial = (Button) findViewById(R.id.btnDial);
        btnDial.setOnClickListener(this);
        btnBrowse = (Button) findViewById(R.id.btnBrowse);
        btnBrowse.setOnClickListener(this);
        btnSMS = (Button) findViewById(R.id.btnSMS);
        btnSMS.setOnClickListener(this);

        mEdit = (EditText) findViewById(R.id.editText);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.print("onStart 시작", Tag);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Logger.print("onResume 시작", Tag);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Logger.print("onPause 시작", Tag);
    }


    @Override
    protected void onStop() {
        super.onStop();
        Logger.print("onStop 시작", Tag);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.print("onRestart 시작", Tag);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.print("onDestroy 시작", Tag);
    }

    public static final int ONE = 1;
    public static final int TWO = 2;

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.mCommon:
                //액티비티로 값 넘기기
                //1.인텐트 생성
                intent = new Intent(this, CommonActivity.class);
                //2. putExtra 함수에 전달할 값 설정
                intent.putExtra("var", mEdit.getText().toString());

                startActivity(intent);
                break;

            case R.id.mTrans1:
                //호출한 액티비티로 부터 값을 돌려 받을 때
                intent = new Intent(this, TransActivity.class);
                //2. putExtra 함수에 전달할 값 설정
                intent.putExtra("var", mEdit.getText().toString());
                intent.putExtra("varNum", 33333);

                startActivityForResult(intent, ONE);
                break;

            case R.id.mTrans2:
                //호출한 액티비티로 부터 값을 돌려 받을 때
                intent = new Intent(this, TransActivity.class);
                //2. putExtra 함수에 전달할 값 설정
                intent.putExtra("var", mEdit.getText().toString());
                intent.putExtra("varNum", 33333);

                startActivityForResult(intent, TWO);
                break;


        }
        //3. Extra에 담긴 값을 intent로 전달한다.
        startActivity(intent);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);



        if(resultCode ==1) {

            Bundle bundle = intent.getExtras();
            String result = bundle.getString("result");
        }

        switch(requestCode){

            case ONE:
                tv1.setText(result);
                break;
            case TWO:
                tv2.setText(result);
                break;
        }
    }
}





