package com.example.paintstory;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class penView extends View {

 private float oldx = 0f;
 private float oldy = 0f;
 private Bitmap bmp = null;
 private Canvas bmpCanvas;
 private Paint paint;
 private Activity _context;

public penView(Context context) {
 super(context);
 _context = (Activity)context;
 paint = new Paint();
 paint.setColor(Color.MAGENTA);
 paint.setAntiAlias(true);
 paint.setStyle(Paint.Style.STROKE);
 paint.setStrokeWidth(6);
 paint.setStrokeCap(Paint.Cap.ROUND);
 paint.setStrokeJoin(Paint.Join.ROUND);
}

 protected void onSizeChanged(int w, int h, int oldw, int oldh) {
 super.onSizeChanged(w,h,oldw,oldh);
 bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
 bmpCanvas = new Canvas(bmp);
 }


 public void onDraw(Canvas canvas) {
 canvas.drawBitmap(bmp, 0, 0, null);
 }

 public boolean onTouchEvent(MotionEvent e){
 switch(e.getAction()){
 case MotionEvent.ACTION_DOWN: //最初のポイント
 oldx = e.getX();
 oldy = e.getY();
 break;
 case MotionEvent.ACTION_MOVE: //途中のポイント
 bmpCanvas.drawLine(oldx, oldy, e.getX(), e.getY(), paint);
 oldx = e.getX();
 oldy = e.getY();
 invalidate();
 break;
 default:
 break;
 }
 return true;
 }

 public void clearDrawList(){
 bmpCanvas.drawColor(Color.WHITE);
 invalidate();
 }

 public void saveToFile(){
 if(!sdcardWriteReady()){
 Toast.makeText(_context, "SDcardが認識されません。", Toast.LENGTH_SHORT).show();
 return;
 }

 File file = new File(Environment.getExternalStorageDirectory().getPath()+"/paintstory/");


 try{
 if(!file.exists()){
 file.mkdir();
 }
 }catch(SecurityException e){}

 String AttachName = file.getAbsolutePath() + "/";
 AttachName += System.currentTimeMillis()+".jpg";
 File saveFile = new File(AttachName);
 while(saveFile.exists()) {
 AttachName = file.getAbsolutePath() + "/" + System.currentTimeMillis() +".jpg";
 saveFile = new File(AttachName);
 }
 try {
 FileOutputStream out = new FileOutputStream(AttachName);
 bmp.compress(CompressFormat.JPEG, 100, out);
 out.flush();
 out.close();
 Toast.makeText(_context, "保存されました。", Toast.LENGTH_SHORT).show();
 } catch(Exception e) {
 Toast.makeText(_context, "例外発生", Toast.LENGTH_SHORT).show();
 }
 }

 private boolean sdcardWriteReady(){
 String state = Environment.getExternalStorageState();
 return (Environment.MEDIA_MOUNTED.equals(state));
 }
}