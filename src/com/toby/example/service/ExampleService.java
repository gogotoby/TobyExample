/*
 * 
 * 參考 http://developer.android.com/guide/components/services.html
 * 
 */
package com.toby.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ExampleService extends Service {
	int mStartMode; // indicates how to behave if the service is killed
	IBinder mBinder; // interface for clients that bind
	boolean mAllowRebind; // indicates whether onRebind should be used

	@Override
	public void onCreate() {
		// The service is being created when the first call to startService()
		Log.d("TobyTest", "ExampleService/ onCreate()");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// The service is starting, due to a call to startService()
		Log.d("TobyTest", "ExampleService/ onStartCommand()");
		return mStartMode;
	}

	@Override
	public IBinder onBind(Intent intent) {
		// A client is binding to the service with bindService()
		Log.d("TobyTest", "ExampleService/ onBind()");
		return mBinder;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// All clients have unbound with unbindService()
		Log.d("TobyTest", "ExampleService/ onUnbind()");
		return mAllowRebind;
	}

	@Override
	public void onRebind(Intent intent) {
		// A client is binding to the service with bindService(),
		// after onUnbind() has already been called
		Log.d("TobyTest", "ExampleService/ onRebind()");
	}

	@Override
	public void onDestroy() {
		// The service is no longer used and is being destroyed
		Log.d("TobyTest", "ExampleService/ onDestroy()");
	}
}
