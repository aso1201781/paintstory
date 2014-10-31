package com.example.paintstory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kyouka34 extends Activity implements
View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kyouka34);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		super.onResume();
		Button hukokugo = (Button)findViewById(R.id.hukokugo);
		hukokugo.setOnClickListener(this);
		Button husansuu = (Button)findViewById(R.id.husansuu);
		husansuu.setOnClickListener(this);
		Button husyakai = (Button)findViewById(R.id.husyakai);
		husyakai.setOnClickListener(this);
		Button hurika = (Button)findViewById(R.id.hurika);
		hurika.setOnClickListener(this);
		Button huzenbu = (Button)findViewById(R.id.huzenbu);
		huzenbu.setOnClickListener(this);
		Button modoru8 = (Button)findViewById(R.id.modoru8);
		modoru8.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){
/*		case R.id.hukokugo:
			Intent intent12 = new Intent(Kyouka34.this,Sheet11.class);
			startActivity(intent12);
		case R.id.husansuu:
			Intent intent13 = new Intent(Kyouka34.this,Sheet8.class);
			startActivity(intent13);
		case R.id.husyakai:
			Intent intent14 = new Intent(Kyouka34.this,Sheet7.class);
			startActivity(intent14);
		case R.id.hurika:
			Intent intent15 = new Intent(Kyouka34.this,Sheet3.class);
			startActivity(intent15);
		case R.id.huzenbu:
			Intent intent17 = new Intent(Kyouka34.this,Sheet7.class);
			startActivity(intent17);
		case R.id.modoru8:
			Intent intent18 = new Intent(Kyouka34.this,Sheet3.class);
			startActivity(intent18);
*/
	}
	}

}
