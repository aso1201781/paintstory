package com.example.paintstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity implements
View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button seiseki = (Button)findViewById(R.id.seiseki);
		seiseki.setOnClickListener(this);
		Button torofi = (Button)findViewById(R.id.torofi);
		torofi.setOnClickListener(this);
		Button illust = (Button)findViewById(R.id.illust);
		illust.setOnClickListener(this);
		Button modoru3 = (Button)findViewById(R.id.modoru3);
		modoru3.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
		case R.id.seiseki:
			Intent intent5 = new Intent(Menu.this,Kiroku.class);
			startActivity(intent5);
		case R.id.torofi:
			Intent intent6 = new Intent(Menu.this,Torotoro1.class);
			startActivity(intent6);
		case R.id.illust:
			Intent intent7 = new Intent(Menu.this,Draw.class);
			startActivity(intent7);
		case R.id.modoru3:
			Intent intent4 = new Intent(Menu.this,Start.class);
			startActivity(intent4);

	}

	}
}


