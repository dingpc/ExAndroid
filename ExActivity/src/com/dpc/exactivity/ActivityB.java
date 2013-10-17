package com.dpc.exactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by PC.DING on 13-9-26.
 */
public class ActivityB extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityb);
        Log.v("PC.DING", "----onCreate in----");
        
        Button buttonb1 = (Button)findViewById(R.id.buttonb1);
        buttonb1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ActivityB.this, ActivityC.class);
				startActivity(intent);
			}
		});
    }

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v("PC.DING", "----onDestroy in----");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.v("PC.DING", "----onPause in----");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.v("PC.DING", "----onRestart in----");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.v("PC.DING", "----onResume in----");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.v("PC.DING", "----onStart in----");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.v("PC.DING", "----onStop in----");
	}
    
    
}