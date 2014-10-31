package com.example.paintstory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kyouka12 extends Activity implements
View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kyouka12);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button yasukokugo = (Button)findViewById(R.id.yasukokugo);
		yasukokugo.setOnClickListener(this);
		Button yasusansuu = (Button)findViewById(R.id.yasusansuu);
		yasusansuu.setOnClickListener(this);
		Button yasuseikatsu = (Button)findViewById(R.id.yasuseikatsu);
		yasuseikatsu.setOnClickListener(this);
		Button yasuzenbu = (Button)findViewById(R.id.yasuzenbu);
		yasuzenbu.setOnClickListener(this);
		Button modoru11 = (Button)findViewById(R.id.modoru11);
		modoru11.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
		case R.id.yasukokugo:
	//		Intent intent12 = new Intent(Kyouka12.this,Sheet11.class);
		//	startActivity(intent12);
	//	case R.id.yasusansuu:
		//	Intent intent13 = new Intent(Kyouka12.this,Sheet8.class);
	//		startActivity(intent13);
		//case R.id.yasuseikatsu:
		//	Intent intent14 = new Intent(Kyouka12.this,Sheet7.class);
			//startActivity(intent14);
		//case R.id.yasuzenbu:
			//Intent intent17 = new Intent(Kyouka12.this,Sheet7.class);
		//	startActivity(intent17);
	//	case R.id.modoru11:
		//	Intent intent18 = new Intent(Kyouka12.this,Sheet3.class);
			//startActivity(intent18);

	}
	}

}