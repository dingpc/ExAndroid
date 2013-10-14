package com.dpc.exercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex);
        
        //�õ�����Button�ؼ�
        Button mButton1 = (Button)findViewById(R.id.button1);
        Button mButton2 = (Button)findViewById(R.id.button2);
        //ΪButton1�󶨵����¼�
        mButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //ʹ��intent����Activityb
                Intent _intent = new Intent(ExActivity.this, ActivityB.class);
                startActivity(_intent);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //����ActivityC
                Intent _intent = new Intent(ExActivity.this, ActivityC.class);
                //����ActivityC֮����лص�
                startActivityForResult(_intent, 100);
            }
        });
    }
    
    /**
     * �ص������������ص����
     * @param requestCode���ص����ص�requestCode
     * @param resultCode��ActivityC���ص�resultCode
     * @param data��ActivityC��Intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == Activity.RESULT_OK) {
            String val = data.getExtras().getString("helloworld");
            TextView textView = (TextView)findViewById(R.id.tvDisplay);
            textView.setText("Value from ActivityC is:" + val);
        }
    }
}