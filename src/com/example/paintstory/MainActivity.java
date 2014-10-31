package com.example.paintstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements
View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button login = (Button)findViewById(R.id.login);
		login.setOnClickListener(this);
		Button idtsukuru = (Button)findViewById(R.id.idtsukuru);
		idtsukuru.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
		case R.id.login:
			Intent intent1 = new Intent(MainActivity.this,Start.class);
			startActivity(intent1);
		case R.id.idtsukuru:
			Intent intent2 = new Intent(MainActivity.this,Touroku.class);
			startActivity(intent2);

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
