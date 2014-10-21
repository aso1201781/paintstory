package com.example.paintstory;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {


	public MySQLiteOpenHelper(Context context){
	super(context,"20140021201781.sqlite3",null,1);
	}





	//表の作成
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ


		//ユーザ所有データ表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
		        "user_take (user_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL , trophy_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL , picture_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL ,FOREIGN KEY (trophy_id)REFERENCES trophy(trophy_id) ,FOREIGN KEY (user_id)REFERENCES user(user_id),FOREIGN KEY (picture_id)REFERENCES picture(picture_id))");

		//プレイ記録表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				" play_record(play_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL , quiz_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL , user_id CHAR(5) AUTOINCREMENT NOT NULL,stage_id CHAR(5) AUTOINCREMENT NOT NULL ,quiz_clear_id CHAR(5) NOT NULL,stage_clear_id CHAR(5) NOT NULL,FOREIGN KEY (quiz_id)REFERENCES quiz(quiz_id),FOREIGN KEY (user_id)REFERENCES user(user_id),FOREIGN KEY (stage_id)REFERENCES stage(stage_id),FOREIGN KEY (quiz_clear_id)REFERENCES quiz_clear(quiz_clear_id),FOREIGN KEY (stage_id)REFERENCES stage_clear(stage_clear_id))");

		//ユーザ表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"user (user_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL , user_name VARCHAR(20)  NOT NULL , clear_count CHAR(5)  NOT NULL )");

		//トロフィー表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"trophy (trophy_id CHAR(5) PRIMARY KEY AUTOINCREMENT  NOT NULL , trophy_name VARCHAR(20)  NOT NULL )");

		//ピクチャー表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"picture (picture_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL , user_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL , image MEDIUMBLOB ,FOREIGN KEY (user_id)REFERENCES user(user_id))");

		//問題表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"quiz (quiz_id CHAR(5) PRIMARY AUTOINCREMENT KEY NOT NULL , quiz_name VARCHAR(20) NOT NULL , quiz_kind_id CHAR(5) AUTOINCREMENT NOT NULL ,FOREIGN KEY (quiz_kind_id)REFERENCES quiz_kind(quiz_kind_id))");

		//問題種類分類表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"quiz_kind (quiz_kind_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL , quiz_kind_name VARCHAR(20) NOT NULL )");

		//ステージ表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"stage (stage_id CHAR(5) PRIMARY KEY AUTOINCREMENT NOT NULL , stage_name VARCHAR(20)  NOT NULL )");

		//問題クリア区分表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"quiz_clear (quiz_clear_id CHAR(5) PRIMARY KEY NOT NULL , quiz_clear VARCHAR(20)  NOT NULL )");

		//ステージ合否区分表
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
				"stage_clear (stage_clear_id CHAR(5) PRIMARY KEY NOT NULL , stage_clear VARCHAR(20)  NOT NULL )");


		
		
		
		  db.execSQL("INSERT INTO user(namename, clear_count) VALUES ('せいま', 0)");

		  db.execSQL("INSERT INTO user(namename, clear_count) VALUES ('せいま', 0)");



	}


	//データベース更新
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("drop table user_take");
		onCreate(db);
		db.execSQL("drop table play_record");
		onCreate(db);
		db.execSQL("drop table user");
		onCreate(db);
		db.execSQL("drop table trophy");
		onCreate(db);
		db.execSQL("drop table picture");
		onCreate(db);
		db.execSQL("drop table quiz");
		onCreate(db);
		db.execSQL("drop table quiz_kind");
		onCreate(db);
		db.execSQL("drop table stage");
		onCreate(db);
		db.execSQL("drop table quiz_clear");
		onCreate(db);
		db.execSQL("drop table stage_clear");
		onCreate(db);

	}




	//その人が所持しているトロフィーの表示
	public SQLiteCursor selecttrophy(SQLiteDatabase db,String id){
		SQLiteCursor cursor = null;
		String sqlstr = "SELECT trophy_name FROM trophy INNER JOIN user_take ON trophy.trophy_id = user_take.trophy_id WHERE user_take.user_name = "+ id +"";

		try{
			cursor = (SQLiteCursor)db.rawQuery(sqlstr,null);
			if(cursor.getCount()!=0){
				cursor.moveToFirst();
			}
		}catch(SQLException e){
			Log.e("ERROR",e.toString());
		}finally{

		}
		return cursor;

		}

	//そのユーザのクリア数を表示する
	public  SQLiteCursor clearCounts(SQLiteDatabase db,String id){
		SQLiteCursor cursor = null;
		String sqlclear ="SELECT clear_count FROM user WHERE user_id=" + id + "";
		try{
			cursor = (SQLiteCursor)db.rawQuery(sqlclear,null);
			if(cursor.getCount()!=0){
				cursor.moveToFirst();
			}
		}catch(SQLException e){
			Log.e("ERROR",e.toString());
		}finally{

		}
		return cursor;

		}


	








	//初めてプレイするユーザに対して会員登録行う。
	public  void SQLiteinsertuser(SQLiteDatabase db, String user_name1){
		String sqluser = "INSERT user(user_name,clear_count) values(" + user_name1 + ",'0')";
		try{
			db.beginTransaction();
			db.execSQL(sqluser);
			db.setTransactionSuccessful();
		}catch(SQLException e){
			Log.e("ERROR",e.toString());
		}finally{
			db.endTransaction();
		}





	}


}
