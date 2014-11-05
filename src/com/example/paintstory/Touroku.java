package com.example.paintstory;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Touroku extends Activity implements
View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.touroku);
	}
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button kettei = (Button)findViewById(R.id.kettei);
		kettei.setOnClickListener(this);
		Button modorutouroku = (Button)findViewById(R.id.modorutouroku);
		modorutouroku.setOnClickListener(this);

		if(sdb == null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			return;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ


		switch(v.getId()){
		case R.id.kettei:

			EditText nametextbox = (EditText)findViewById(R.id.nametextbox);
		String user_name = nametextbox.getText().toString();
		if(user_name!=null && user_name.isEmpty()){
			helper.SQLiteinsertuser(sdb,user_name);
			helper.user_get_id(sdb,user_name);
		}
			Intent intent1 = new Intent(Touroku.this,Id.class);
			intent1.putExtra("user_id",user_name);
			startActivity(intent1);




		case R.id.modorutouroku:
			Intent intent2 = new Intent(Touroku.this,Id.class);
			startActivity(intent2);

		}
	}

}
