package com.dpc.exactivity;

import com.dpc.exactivity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by PC.DING on 13-9-26.
 */
public class ActivityC extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityc);
        Button button1 = (Button)findViewById(R.id.buttonc1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent data = new Intent();
                EditText editText = (EditText)findViewById(R.id.etActivityc);
                String val = editText.getText().toString();
                data.putExtra("helloworld", val);
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
        
        Button button2 = (Button)findViewById(R.id.buttonc2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	onKeyDown(KeyEvent.KEYCODE_BACK, null);
            }
        });
    }
}