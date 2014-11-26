
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
			Button btnRELATIVE2 = (Button)findViewById(R.id.buttonda);
			btnRELATIVE2.setOnClickListener(this);
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
				
			case R.id.buttonda:
				String abc = "くさや";
				Boolean aaa =false;
				TextView text = (TextView)findViewById(R.id.textView1);
				TextView text2 = (TextView)findViewById(R.id.textView2);
				TextView text3 = (TextView)findViewById(R.id.textView3);
				TextView text4 = (TextView)findViewById(R.id.textView4);
				TextView text5 = (TextView)findViewById(R.id.textView5);
				TextView text6 = (TextView)findViewById(R.id.textView6);
				TextView text7 = (TextView)findViewById(R.id.textView8);
				EditText nametextbox = (EditText)findViewById(R.id.editText1);
				String inputMsg = nametextbox.getText().toString();
				if(inputMsg!=null && !inputMsg.isEmpty()){
					//ユーザ表にユーザ情報を新規登録
					String a = helper.trophy(sdb,inputMsg);
				//IDがちがう
					if(a.equals(abc)){
						text7.setText("入力がまちがってるよ");
						break;
					}else{if(!aaa){text.setText("ステージ１クリアおめでとう！！");
						aaa = true;
					}else{text2.setText("ステージ２クリアおっめでとう！！");
						
					}
					
					}
			
			
			
			
			
			
			
			
			
				}
			
			
			case R.id.modoru: // LinearLayoutボタンが押された

					// インテントのインスタンス生成
					intent = new Intent(Torotoro1.this, Menu.class);
					break;
		}
			startActivity(intent);
		}

	}