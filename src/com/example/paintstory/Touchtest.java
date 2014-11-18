package com.example.paintstory;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Touchtest extends Activity {
 penView penview;

 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 penview= new penView(this);
 setContentView(penview);
 }
 /** メニューの生成イベント */
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
 super.onCreateOptionsMenu(menu);
 getMenuInflater().inflate(R.menu.main,menu);
 return true;
 }
 /** メニューがクリックされた時のイベント */
 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
 switch ( item.getItemId() ) {
 case R.id.item1:
 penview.clearDrawList();
 break;
 case R.id.item2:
 penview.saveToFile();
 break;
 case R.id.item3:
 finish();
 break;
 }
 return true;
 }

}