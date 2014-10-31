package com.example.paintstory;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
public class Kiroku extends Activity implements View.OnClickListener  {

	
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kiroku);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btnRELATIVE = (Button)findViewById(R.id.modoru);
		btnRELATIVE.setOnClickListener(this);
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
		Intent intent = null;
		switch(v.getId()) { //どのボタンが押されたか判定
			case R.id.modoru: // LinearLayoutボタンが押された

				// インテントのインスタンス生成
				intent = new Intent(Kiroku.this, Torotoro1.class);
				break;
	}
		startActivity(intent);


	}
}
