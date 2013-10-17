package com.dpc.broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dpc.exbroadcast.MainActivity;
import com.dpc.exbroadcast.R;

public class StaticBroadcastReceiver extends BroadcastReceiver {

	private Context context;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v("PC.DING", "----StaticBroadcastReceiver onReceive----");
		this.context = context;
		showNotification(intent);
	}
	
	private void showNotification(Intent intent) {
		/*
		NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.ic_launcher, intent.getExtras().getString("content"), System.currentTimeMillis());
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);
		notification.setLatestEventInfo(context, intent.getExtras().getString("content"), null, pendingIntent);
		notificationManager.notify(R.layout.main, notification);
		*/
		NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);
		Notification notification = new Notification.Builder(context).addAction(R.drawable.ic_launcher, intent.getExtras().getString("content"), pendingIntent).build();
		notificationManager.notify(R.layout.main, notification);
	}

}