package com.dazhongcun.baseactivity;


import com.dazhongcun.application.BaseApplication;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import roboguice.activity.RoboActivity;

@SuppressLint("NewApi")
public class BaseActionBarActivity extends ActionBarActivity{

	//广播  处理接收到广播后关闭activityh
	protected BroadcastReceiver broadcast = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			finish();
		}
	};
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(broadcast);
	}

	@Override
	protected void onResume() {
		super.onResume();
		IntentFilter filter = new IntentFilter();
		filter.addAction(BaseApplication.EXIT_APP);
		this.registerReceiver(broadcast, filter);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	
	
	
}
