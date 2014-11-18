package com.example.paintstory;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements
View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;
	
	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button modoru = (Button)findViewById(R.id.modorutouroku);
		modoru.setOnClickListener(this);
		Button login = (Button)findViewById(R.id.login);
		login.setOnClickListener(this);
		Button idtsukuru = (Button)findViewById(R.id.idtsukuru);
		idtsukuru.setOnClickListener(this);
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
		case R.id.login:
			
			TextView abc =(TextView)findViewById(R.id.textView4);
			EditText etv1 = (EditText)findViewById(R.id.editText1);
			EditText etv2 = (EditText)findViewById(R.id.edttxt2);
			String name = etv1.getText().toString();
			String id = etv2.getText().toString();
			//文字が入ってないときの処理
		//    }else{//戻り値があれば認証
		//		if(user_info != null){
			//	SQLiteCursor user_info = helper.name_ninsyo(sdb,name,id);
			//入力フォームがＮＵＬＬじゃなければユーザ表のユーザ情報と入力した情報を比較
				/*if(  name == null  && id == null ){
			abc.setText("名前とＩＤをいれてね");
			}else if(name == null && id != null || name != null && id == null){
				abc.setText("名前かＩＤを入れわすれてるよ");
			}else{
				
				this.helper.selectHitokoto(sdb);
				Intent intent1 = new Intent(MainActivity.this,Start.class);
				startActivity(intent1);
					 
					 abc.setText("認証に失敗しました");
			} 	  
			  */
			if(name!=null && !name.isEmpty() &&id!=null && !id.isEmpty())
			{
				
				String rtString2 = helper.ninsyo(sdb,id,name);
				//Log.d("----",rtString2);
				if(rtString2.equals(name)){
					Intent intent1 = new Intent(MainActivity.this,Start.class);
					startActivity(intent1);
					}else{
					
					 abc.setText("あなたは会員じゃないです！");
			    	}
			}else{
					abc.setText("なまえ、ＩＤを入力しわすれてます！");
				 }
			
		
			//rtString2.equals(id)
		
			  break;
			  
			  
			  
		case R.id.idtsukuru:
			Intent intent2 = new Intent(MainActivity.this,Touroku.class);
			startActivity(intent2);
		    break;
			
			
			case R.id.modorutouroku:
				Intent intent3 = new Intent(MainActivity.this,Start.class);
				startActivity(intent3);
				break;
			}
		    
		    
			
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
