package com.dpc.service;

import android.app.IntentService;
import android.content.Intent;

public class HelloIntentService extends IntentService {

	public HelloIntentService () {
		super("HelloIntentService");
	}
	@Override
	protected void onHandleIntent(Intent arg0) {
		System.out.println("休息8秒！");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onDestroy() {
		System.out.println("执行完onHandleIntent之后会自动调用");
		super.onDestroy();
	}

}
