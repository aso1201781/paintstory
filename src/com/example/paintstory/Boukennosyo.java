package com.example.paintstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Boukennosyo extends Activity implements
View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.boukennosyo);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button hazime = (Button)findViewById(R.id.hazime);
		hazime.setOnClickListener(this);
		Button tsuduki = (Button)findViewById(R.id.tsuduki);
		tsuduki.setOnClickListener(this);
		Button modoru2 = (Button)findViewById(R.id.modoru2);
		modoru2.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
		case R.id.hazime:
			Intent intent3 = new Intent(Boukennosyo.this,Gakunen.class);
			startActivity(intent3);
			break;

		case R.id.tsuduki:
		//	Intent intent4 = new Intent(Boukennosyo.this,船津.class);
		//	startActivity(intent4);
		//  break;
		case R.id.modoru2:
			Intent intent5 = new Intent(Boukennosyo.this,Start.class);
			startActivity(intent5);
			break;
	}

}
	}
