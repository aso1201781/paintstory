
package com.example.paintstory;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
 public class Torotoro1  extends Activity implements View.OnClickListener{
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.torotoro1);
		}

		SQLiteDatabase sdb = null;
		MySQLiteOpenHelper helper = null;
		
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
					intent = new Intent(Torotoro1.this, Draw.class);
					break;
		}
			startActivity(intent);
		}

	}