package com.dpc.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class HelloContentProvider extends ContentProvider {
	
	//初始化
	private static final UriMatcher um = new UriMatcher(UriMatcher.NO_MATCH);
	private SQLiteDatabase sqLite;
	private static final String DB_PATH = "/data/data/com.dpc.exprovider/";
	private static final String DB_NAME = "providerdb";
	private static final String BOOK_URI = "com.dpc.provider.books"; 
	private static final String TABLE_NAME = "books"; 
	
	@Override
	public boolean onCreate() {
		Log.v("PC.DING", "HelloContentProvider in");
		//注册需要的uri
		um.addURI(BOOK_URI, "book", 1);
		sqLite = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, 
				null, 
				SQLiteDatabase.OPEN_READWRITE|SQLiteDatabase.CREATE_IF_NECESSARY);
		//若books表存在，则删除
		if(tabIsExist(TABLE_NAME)) {
			sqLite.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		}
		sqLite.execSQL("create table books ([id] integer primary key autoincrement not null, [bookname] varchar(30) not null)");
		ContentValues cv = new ContentValues();
		cv.put("bookname", "自学成才");
		sqLite.insert(TABLE_NAME, null, cv);
		return false;
	}
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		if(um.match(uri) == 1) {
			Cursor cursor = sqLite.query(TABLE_NAME, null, null, null, null, null, null);
			return cursor;
		} else {
			return null;
		}
	}
	
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		if(um.match(uri) == 1) {
			int result = sqLite.update(TABLE_NAME, values, null, null);
			return result;
		}
		return 0;
	}
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}
	
	public boolean tabIsExist(String tabName) {
		boolean result = false;
		if (tabName == null) {
			return false;
		}
		Cursor cursor = null;
		try {

			String sql = "select count(*) as c from sqlite_master where type ='table' and name ='"
					+ tabName.trim() + "' ";
			cursor = sqLite.rawQuery(sql, null);
			if (cursor.moveToNext()) {
				int count = cursor.getInt(0);
				if (count > 0) {
					result = true;
				}
			}
		} catch (Exception e) {
		}
		return result;
	}
}
