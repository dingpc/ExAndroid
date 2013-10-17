package com.dpc.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class HelloService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		int startSticky = super.onStartCommand(intent, flags, startId);
		System.out.println("����Service,��Ϣ10��");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return startSticky;
	}

}
