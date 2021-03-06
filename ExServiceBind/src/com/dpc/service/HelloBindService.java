package com.dpc.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class HelloBindService extends Service {

	private final IBinder mBinder = new LocalBinder();
	private String BOOK_NAME = "自学成才";
	
	public class LocalBinder extends Binder {
		public HelloBindService getService() {
			return HelloBindService.this;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Toast.makeText(this, "成功绑定Service", 1000).show();
		return mBinder;
	}
	
	public boolean onUnbind(Intent intent) {
		Toast.makeText(this, "成功取消绑定Service", 1000).show();
		return false;
	}
	
	public String getBookName() {
		return BOOK_NAME;
	}
}
