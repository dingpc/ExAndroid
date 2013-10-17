package com.dpc.service;

import android.app.IntentService;
import android.content.Intent;

public class HelloIntentService extends IntentService {

	public HelloIntentService () {
		super("HelloIntentService");
	}
	@Override
	protected void onHandleIntent(Intent arg0) {
		System.out.println("��Ϣ8�룡");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onDestroy() {
		System.out.println("ִ����onHandleIntent֮����Զ�����");
		super.onDestroy();
	}

}
