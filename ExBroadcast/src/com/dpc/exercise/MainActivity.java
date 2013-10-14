package com.dpc.exercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context mContext;
	private Button btnSendBroadcast;
	private TextView etBroadcastContent;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mContext = this;
        btnSendBroadcast = (Button) findViewById(R.id.btn_sendBroadcast);
        btnSendBroadcast.setOnClickListener(new SendBroadcastClickListener());
        etBroadcastContent = (TextView) findViewById(R.id.et_broadcastcontent);
    }
    
    private class SendBroadcastClickListener implements OnClickListener {

		public void onClick(View v) {
			String content = etBroadcastContent.getText().toString().trim();
			if(content.length() < 1) {
				Toast.makeText(mContext, etBroadcastContent.getHint(), 1).show();
				return;
			}
			Intent intent = new Intent();
			intent.setAction("com.dpc.action.BroadcastReceiverTest");
			intent.putExtra("content", content);
			sendBroadcast(intent);
		}
    }
}
