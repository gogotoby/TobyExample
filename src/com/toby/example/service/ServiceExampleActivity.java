package com.toby.example.service;

import com.toby.example.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServiceExampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_example);
	}

	public void onClick(View view) {
		if (view.getId() == R.id.start_btn) {
			startService(new Intent(this, ExampleService.class));
		} else {
			stopService(new Intent(this, ExampleService.class));
		}
	}
}
