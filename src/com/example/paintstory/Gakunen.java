package com.example.paintstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gakunen extends Activity implements
View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gakunen);
		}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button ichini = (Button)findViewById(R.id.ichini);
		ichini.setOnClickListener(this);
		Button sanshi = (Button)findViewById(R.id.sanshi);
		sanshi.setOnClickListener(this);
		Button goroku = (Button)findViewById(R.id.goroku);
		goroku.setOnClickListener(this);
		Button modoru4 = (Button)findViewById(R.id.modoru4);
		modoru4.setOnClickListener(this);
		}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
		case R.id.ichini:
			Intent intent8 = new Intent(Gakunen.this,Kyouka12.class);
			startActivity(intent8);
		case R.id.sanshi:
			Intent intent9 = new Intent(Gakunen.this,Kyouka34.class);
			startActivity(intent9);
		case R.id.goroku:
			Intent intent10 = new Intent(Gakunen.this,Kyouka56.class);
			startActivity(intent10);
		case R.id.modoru4:
			Intent intent11 = new Intent(Gakunen.this,Boukennosyo.class);
			startActivity(intent11);
			}
		}
}
