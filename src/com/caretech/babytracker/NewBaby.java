package com.caretech.babytracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

public class NewBaby extends Activity implements OnClickListener {

	EditText name;
	EditText dob;
	Spinner gender;
	SeekBar weight;
	SeekBar length;
	EditText doctor;
	EditText hospital;
	Button save;
	Button back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_baby);

		name = (EditText) findViewById(R.id.txt_name);
		dob = (EditText) findViewById(R.id.txt_dob);
		gender = (Spinner) findViewById(R.id.spinner_gender);
		weight = (SeekBar) findViewById(R.id.seekbar_weight);
		length = (SeekBar) findViewById(R.id.seek_length);
		doctor = (EditText) findViewById(R.id.txt_doctor);
		hospital = (EditText) findViewById(R.id.txt_hospital);
		save = (Button) findViewById(R.id.btn_save);
		back = (Button) findViewById(R.id.btn_back);

		save.setOnClickListener(this);

	}

	@Override
	public void onClick(View src) {
		switch (src.getId()) {
		case R.id.btn_save:

			break;
		case R.id.btn_back:
			finish();
			startActivity(new Intent(".MenuActivity"));
			break;
		}
	}

}