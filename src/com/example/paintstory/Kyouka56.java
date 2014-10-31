package com.example.paintstory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kyouka56 extends Activity implements
View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kyouka56);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		super.onResume();
		Button nankokugo = (Button)findViewById(R.id.nankokugo);
		nankokugo.setOnClickListener(this);
		Button nansansuu = (Button)findViewById(R.id.nansansuu);
		nansansuu.setOnClickListener(this);
		Button nansyakai = (Button)findViewById(R.id.nansyakai);
		nansyakai.setOnClickListener(this);
		Button nanrika = (Button)findViewById(R.id.nanrika);
		nanrika.setOnClickListener(this);
		Button naneigo = (Button)findViewById(R.id.naneigo);
		naneigo.setOnClickListener(this);
		Button nanzenbu = (Button)findViewById(R.id.nanzenbu);
		nanzenbu.setOnClickListener(this);
		Button modoru7 = (Button)findViewById(R.id.modoru7);
		modoru7.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
/*		case R.id.nankokugo:
			Intent intent12 = new Intent(Kyouka56.this,Sheet11.class);
			startActivity(intent12);
		case R.id.nansansuu:
			Intent intent13 = new Intent(Kyouka56.this,Sheet8.class);
			startActivity(intent13);
		case R.id.nansyakai:
			Intent intent14 = new Intent(Kyouka56.this,Sheet7.class);
			startActivity(intent14);
		case R.id.nanrika:
			Intent intent15 = new Intent(Kyouka56.this,Sheet3.class);
			startActivity(intent15);
		case R.id.naneigo:
			Intent intent16 = new Intent(Kyouka56.this,Sheet8.class);
			startActivity(intent16);
		case R.id.nanzenbu:
			Intent intent17 = new Intent(Sheet7.this,Sheet7.class);
			startActivity(intent17);
		case R.id.modoru7:
			Intent intent18 = new Intent(Sheet7.this,Sheet3.class);
			startActivity(intent18);
*/
	}
	}

}
