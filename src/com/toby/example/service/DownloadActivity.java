package com.toby.example.service;

import com.toby.example.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.widget.Toast;

public class DownloadActivity extends Activity {

	// This Handler class should be static or leaks might occur
	private Handler handler = new Handler() {
		public void handleMessage(Message message) {
			Object path = message.obj;
			if (message.arg1 == RESULT_OK && path != null) {
				Toast.makeText(DownloadActivity.this, "Downloaded" + path.toString(),
						Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(DownloadActivity.this, "Download failed.", Toast.LENGTH_LONG).show();
			}

		};
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.download);

	}

	public void onClick(View view) {
		Intent intent = new Intent(this, DownloadService.class);
		// Create a new Messenger for the communication back
		// 
		// Create a new Messenger pointing to the given Handler. Any Message
		// objects sent through this Messenger will appear in the Handler as if (猶如)
		// Handler.sendMessage(Message) had been called directly.
		Messenger messenger = new Messenger(handler);
		intent.putExtra("MESSENGER", messenger);
		intent.setData(Uri.parse("http://www.vogella.com/index.html")); // for data.getLastPathSegment()
		intent.putExtra("urlpath", "http://www.vogella.com/index.html"); // url.openConnection()
		startService(intent);
	}
}
