package com.example.paintstory;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
			String abc = "くさや";
			TextView text = (TextView)findViewById(R.id.textView2);
			EditText nametextbox = (EditText)findViewById(R.id.nametextbox);
			String inputMsg = nametextbox.getText().toString();

				if(inputMsg!=null && !inputMsg.isEmpty()){
					//ユーザ表にユーザ情報を新規登録
					String a = helper.juhukusagashi(sdb,inputMsg);
					if(a.equals(abc)){
						helper.insertHitokoto(sdb,inputMsg);
						text.setText("あなたの名前は"+inputMsg);
						String rtString = helper.selectHitokoto(sdb,inputMsg);
						Intent intent = new Intent(Touroku.this,Kiroku.class);
						intent.putExtra("id",rtString);
						intent.putExtra("name", inputMsg);
						startActivity(intent);
						break;
					}
						else{text.setText("おなじなまえのともだちがもういるよ！ちがう名前をとうろくしてね");
						break;
						}
				}else{text.setText("なまえがはいってないよ！！");
	    	break;}
					//入力した名前をキーにユーザＩＤを取得
				//	SQLiteCursor user_id =helper.user_get_id(sdb,user_name);

				//		if(user_id != null){
					//		text.setText(user_name+"さんのユーザＩＤは"+user_id+"です");
						//}else{text.setText("ID取得に失敗しました");
					//	}

	//		}else{text.setText(user_name);}



			case R.id.modorutouroku:
			Intent intent2 = new Intent(Touroku.this,MainActivity.class);
			startActivity(intent2);
			break;



		}
	}
}