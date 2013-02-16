package com.caretech.babytracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Baby {
	public static final String KEY_BABYID = "_id";
	public static final String BABY_NAME = "baby_name";
	public static final String BABY_DOB = "baby_dob";
	public static final String BABY_GENDER = "baby_gender";
	public static final String BABY_WEIGHT = "baby_weight";
	public static final String BABY_HEIGHT = "baby_HEIGHT";
	public static final String BABY_DOCTOR = "baby_doctor";
	public static final String BABY_HOSPITAL = "baby_hospital";

	private static final String DATABASE_NAME = "BabyTracker.db";
	private static final String DATABASE_TABLE = "baby";
	private static final int DATABASE_VERSION = 1;

	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static class DbHelper extends SQLiteOpenHelper {
		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_BABYID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + BABY_NAME
					+ " TEXT NOT NULL, " + BABY_DOB + " TEXT NOT NULL, "
					+ BABY_GENDER + " TEXT NOT NULL, " + BABY_WEIGHT
					+ " REAL NULL, " + BABY_HEIGHT + " REAL NULL, "
					+ BABY_DOCTOR + " TEXT," + BABY_HOSPITAL + " TEXT" + ");");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
	}

	public Baby(Context c) {
		ourContext = c;
	}

	public Baby open() {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();

		return this;
	}

	public void close() {
		ourHelper.close();
	}

	public long createEntry(String name, String dob, String gender,
			Double weight, Double height, String doctor, String hospital) {
		ContentValues cv = new ContentValues();

		cv.put(BABY_NAME, name);
		cv.put(BABY_DOB, dob.toString());
		cv.put(BABY_GENDER, gender);
		cv.put(BABY_WEIGHT, weight);
		cv.put(BABY_HEIGHT, height);
		cv.put(BABY_DOCTOR, doctor);
		cv.put(BABY_HOSPITAL, hospital);

		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
}