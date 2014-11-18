package com.example.paintstory;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

	/**
	 * @param context 呼び出しコンテクスト
	 * @param name 利用DB名
	 * @param factory カーソルファクトリー
	 * @param version DBバージョン
	 */
	public MySQLiteOpenHelper(Context context){
		super(context, "20140021201771.sqlite3", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ



		//プレイ記録表
		//db.execSQL("CREATE TABLE IF NOT EXISTS " +
			//	" play_record(play_id TEXT PRIMARY KEY AUTOINCREMENT NOT NULL , quiz_id TEXT PRIMARY KEY AUTOINCREMENT NOT NULL , _id TEXT AUTOINCREMENT NOT NULL,stage_id TEXT AUTOINCREMENT NOT NULL ,quiz_clear_id TEXT NOT NULL,stage_clear_id TEXT NOT NULL)");

	//ピクチャー表
	//db.execSQL("CREATE TABLE IF NOT EXISTS " +
		//	"picture (picture_id TEXT PRIMARY KEY AUTOINCREMENT NOT NULL , _id TEXT PRIMARY KEY AUTOINCREMENT NOT NULL , image BLOB ,FOREIGN KEY (_id)REFERENCES user(_id))");

	//問題表
	//db.execSQL("CREATE TABLE IF NOT EXISTS " +
		//	"quiz (quiz_id TEXT PRIMARY AUTOINCREMENT KEY NOT NULL , quiz_name TEXT NOT NULL , quiz_kind_id TEXT AUTOINCREMENT NOT NULL ,FOREIGN KEY (quiz_kind_id)REFERENCES quiz_kind(quiz_kind_id))");

	//問題種類分類表
//	db.execSQL("CREATE TABLE IF NOT EXISTS " +
	//		"quiz_kind (quiz_kind_id TEXT PRIMARY KEY AUTOINCREMENT NOT NULL , quiz_kind_name TEXT NOT NULL )");

	//ステージ表
//	db.execSQL("CREATE TABLE IF NOT EXISTS " +
	//		"stage (stage_id TEXT PRIMARY KEY AUTOINCREMENT NOT NULL , stage_name TEXT  NOT NULL )");

	//問題クリア区分表
	//db.execSQL("CREATE TABLE IF NOT EXISTS " +
		//	"quiz_clear (quiz_clear_id TEXT PRIMARY KEY NOT NULL , quiz_clear TEXT  NOT NULL )");

	//ステージ合否区分表
//	db.execSQL("CREATE TABLE IF NOT EXISTS " +
	//		"stage_clear (stage_clear_id TEXT PRIMARY KEY NOT NULL , stage_clear TEXT  NOT NULL )");



		//ユーザ所有トロフィーデータ表
		// 表の先頭のカラムは_idという名前に
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"Hitokoto (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , phrase TEXT)");


		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"user_take_trophy (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , trophy_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
		//ユーザ所有クリアデータ表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"user_take_clear(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , clear_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");

		//トロフィー表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"trophy (trophy_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL , trophy_name TEXT  NOT NULL )");


		//クリア表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"clear (clear_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL , clear_name TEXT  NOT NULL )");

		//ユーザ情報
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"user (_id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL , user_name TEXT ,clear_count INTEGER )");



	}



	@Override

		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO 自動生成されたメソッド・スタブ
		db.execSQL("drop table Hitokoto");
		  onCreate(db);
		db.execSQL("drop table user_take_trophy");
			  onCreate(db);
			db.execSQL("drop table user_take_clear");
			  onCreate(db);
			db.execSQL("drop table trophy");
			  onCreate(db);
			db.execSQL("drop table clear");
			  onCreate(db);
			 db.execSQL("drop table user");
			  onCreate(db);
			  //db.execSQL("drop table picture");
			//  onCreate(db);
			//db.execSQL("drop table quiz");
			//  onCreate(db);
			//db.execSQL("drop table quiz_kind");
			//	onCreate(db);
			//db.execSQL("drop table stage");
			//	onCreate(db);
			//db.execSQL("drop table quiz_clear");
			//	onCreate(db);
			//db.execSQL("drop table stage_clear");
			//	onCreate(db);
			//db.execSQL("drop table play_record");
			//  onCreate(db);
		}
	public void insertHitokoto(SQLiteDatabase db, String inputMsg){
		String sqlstr = " insert into Hitokoto (phrase) values('" + inputMsg + "'); ";
			try {
				db.beginTransaction();
				db.execSQL(sqlstr);
				db.setTransactionSuccessful();
			} catch (SQLException e) {
				Log.e("ERROR", e.toString());
			}finally {
				db.endTransaction();
			}
		return;
	}






	public String selectHitokoto(SQLiteDatabase db,String name){
		String rtString = null;
		String sqlstr = "SELECT _id, phrase  FROM Hitokoto WHERE phrase ='" +name+ "'; ";
			try {
				SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(sqlstr, null);

				if(cursor.getCount()!=0){cursor.moveToFirst();}



					rtString = cursor.getString(0);



				cursor.close();

			} catch (SQLException e) {
				Log.e ("ERROR", e.toString());
			}finally{
				//既にカーソルもcloseしてあるので何もしない。
			}
		return rtString;
	}





	public String ninsyo(SQLiteDatabase db,String _id,String name){
		String rtString2 = null;
		String sqlstr = "SELECT _id, phrase FROM Hitokoto WHERE _id = " + _id +" AND phrase = '"+name+"'; ";
		Log.d("-mysql-",sqlstr);
			try {
				SQLiteCursor cursor = (SQLiteCursor)db.rawQuery(sqlstr, null);


			      if(cursor.getCount()!=0)
			        {cursor.moveToFirst();


			            	rtString2 = cursor.getString(1);
			            }else{
			            	rtString2 = "くさや";

			            }



					} catch (SQLException e) {
					Log.e ("ERROR", e.toString());
			}finally{
				//既にカーソルもcloseしてあるので何もしない。
			}
			//Log.d("-mysql-",rtString2);
		return rtString2;
	}









	public  SQLiteCursor name_ninsyo(SQLiteDatabase db,String _id,String user_name ){
		SQLiteCursor cursor = null;
		String sqlclear ="SELECT _id FROM Hitokoto WHERE _id=" + _id +" AND phrase="+user_name+";";
		try{
			cursor = (SQLiteCursor)db.rawQuery(sqlclear,null);
			if(cursor.getCount()!=0){cursor.moveToFirst();
			}while(cursor.moveToNext()){


			}

		}catch(SQLException e){
			Log.e("ERROR",e.toString());
		}finally{

		}
		return cursor;

		}





	public void deleteHitokoto(SQLiteDatabase db, int id){
		String sqlstr = "DELETE FROM Hitokoto WHERE _id = " + id + " ;";
			try {
				db.beginTransaction();
				db.execSQL(sqlstr);
				db.setTransactionSuccessful();
			} catch (SQLException e) {
				Log.e("ERROR", e.toString());
			}finally {
				db.endTransaction();
			}
		return;
	}



	public SQLiteCursor selectHitokotoList2(SQLiteDatabase db,String user_name,String _id) {
		SQLiteCursor cursor = null;

		String sqlstr = "SELECT _id, phrase FROM Hitokoto WHERE _id=" + _id +" AND phrase="+user_name+"; ";
		try {
			cursor = (SQLiteCursor)db.rawQuery(sqlstr, null);
			if(cursor.getCount()!=0){
				cursor.moveToFirst();
			}
		} catch (SQLException e) {
			Log.e("ERROR", e.toString());
		}finally {

		}

		return cursor;
	}




	public SQLiteCursor selectHitokotoList(SQLiteDatabase db) {
		SQLiteCursor cursor = null;

		String sqlstr = "SELECT _id, phrase FROM Hitokoto ORDER BY _id; ";
		try {
			cursor = (SQLiteCursor)db.rawQuery(sqlstr, null);
			if(cursor.getCount()!=0){
				cursor.moveToFirst();
			}
		} catch (SQLException e) {
			Log.e("ERROR", e.toString());
		}finally {

		}

		return cursor;
	}


}
