package com.example.paintstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends Activity implements
View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button mainstart = (Button)findViewById(R.id.mainstart);
		mainstart.setOnClickListener(this);
		Button kiroku = (Button)findViewById(R.id.kiroku);
		kiroku.setOnClickListener(this);
		Button ewokaku = (Button)findViewById(R.id.ewokaku);
		ewokaku.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
		case R.id.mainstart:
			Intent intent1 = new Intent(Start.this,Boukennosyo.class);
			startActivity(intent1);
			break;
		case R.id.kiroku:
			Intent intent2 = new Intent(Start.this,Menu.class);
			startActivity(intent2);
			break;
		case R.id.ewokaku:
			Intent intent111 = new Intent(Start.this,Touchtest.class);
			startActivity(intent111);
			break;
		}
	}

}
