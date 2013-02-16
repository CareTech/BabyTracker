package com.caretech.babytracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Task {
	public static final String KEY_TASKID = "_id";
	public static final String TASK_NAME = "task_name";
	public static final String TASK_DUEDATE = "task_duedate";
	public static final String TASK_DUETIME = "task_DUETIME";
	public static final String TASK_NOTES = "task_notes";

	private static final String DATABASE_NAME = "BabyTracker.db";
	private static final String DATABASE_TABLE = "task";
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
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_TASKID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + TASK_NAME
					+ " TEXT NOT NULL, " + TASK_DUEDATE + " TEXT NOT NULL, "
					+ TASK_DUETIME + " TEXT NOT NULL, " + TASK_NOTES
					+ " TEXT NOT NULL" + ";)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
	}

	public Task(Context c) {
		ourContext = c;
	}

	public Task open() {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();

		return this;
	}

	public void close() {
		ourHelper.close();
	}

	public long createEntry(String taskname, String duedate, String duetime,
			String notes) {
		ContentValues cv = new ContentValues();

		cv.put(TASK_NAME, taskname);
		cv.put(TASK_DUEDATE, duedate);
		cv.put(TASK_DUETIME, duetime);
		cv.put(TASK_NOTES, notes);

		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
}