package com.dpc.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DynamicBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("PC.DING", "----DynamicBroadcastReceiver onReceive----");
		Toast.makeText(context, intent.getExtras().getString("tips"), 1).show();
	}

}
