package com.caretech.babytracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;

public class NewTask extends Activity implements OnClickListener {

	EditText taskname;
	EditText duedate;
	EditText duetime;
	EditText notes;

	Button save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_task);

		EditText dueDate = (EditText) findViewById(R.id.txtDueDate);

		dueDate.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus == true) {
				}
			}
		});

		taskname = (EditText) findViewById(R.id.txtTaskName);
		duetime = (EditText) findViewById(R.id.txtDueTime);
		notes = (EditText) findViewById(R.id.txtNotes);

		save = (Button) findViewById(R.id.btnSave);

		save.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSave:
			Task entry = new Task(getApplicationContext());
			entry.open();
			entry.createEntry(taskname.getText().toString(), duedate.getText()
					.toString(), duetime.getText().toString(), notes.getText()
					.toString());
			entry.close();
			break;
		}

	}

}