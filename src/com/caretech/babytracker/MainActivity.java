package com.caretech.babytracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button createNewBaby;
	Intent newscreen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		createNewBaby = (Button) findViewById(R.id.newbaby_btn);
		createNewBaby.setOnClickListener(this);

	}

	@Override
	public void onClick(View src) {
		switch (src.getId()) {
		case R.id.newbaby_btn:
			startActivity(new Intent(".NewBaby"));
			break;

		}
	}

}