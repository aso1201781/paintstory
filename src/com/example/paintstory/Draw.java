


package com.example.paintstory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.provider.MediaStore.MediaColumns;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;






public class Draw extends Activity implements View.OnClickListener{
	static final int REQUEST_PICK_PICTURE = 11112222;
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.draw);
		
			// ボタンが押された時の処理
		
			Button button = (Button)this.findViewById(R.id.buttonda);
	        button.setOnClickListener(new OnClickListener() {
	             
	            @Override
	            public void onClick(View v) {
	                 
	                // _______________________________
	                // Intentを使ってギャラリーを呼び出す
	                Intent intent = new Intent(Intent.ACTION_PICK);
	                intent.setType("image/*");
	                startActivityForResult(intent, REQUEST_PICK_PICTURE);
	                 
	                 
	            }
	        });
	         
	 
	        // _______________________________
	        // 保存した画像がある場合は、それを表示しておく
	         
	        // 保存したPNGをロード
	        Bitmap png = this.loadPictureFromLocal("test.png");
	 
	        if (png != null) {
	             
	            // テキストビューにリサイズ後の画像サイズを設定する
	       //     TextView tv = (TextView)this.findViewById(R.id.textView2);
	  //          tv.setText(png.getWidth() + " x " + png.getHeight());
	     
	            // 変更したBmp表示用View
	  //          ImageView iv2 = (ImageView)this.findViewById(R.id.imageView2);
	  //          iv2.setImageBitmap(png);
	        }
	    }
	 
	    // ______________________________________________________________________________
	    @Override   // メニューの作成処理
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	 
	     
	    // ______________________________________________________________________________
	    @Override   // Intent処理の結果が戻ってくる
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	         
	        // Intent呼び出しの時のリクエストコード
	        if (requestCode == REQUEST_PICK_PICTURE) {
	             
	            // 画像がちゃんと選択されました
	            if (resultCode == RESULT_OK) {
	                 
	                // 送られてきたファイルのパスを取り出す
	                // 
	                 
	                // getDataでURIが送られてくるのでファイル名を取り出す
	                String[] columns = { MediaColumns.DATA };
	                Cursor cur = getContentResolver().query(data.getData(),
	                        columns, null, null, null);
	                cur.moveToNext();
	                 
	                // ファイルパス
	                String filePath = cur.getString(0);
	                if (filePath == null) {
	                    Toast.makeText(this, "指定のファイルは読み込めないらしい", Toast.LENGTH_SHORT).show();
	                    return ;
	                }
	                 
	                 
	                // ファイルから読み込んで、指定のサイズへ変換
	                // 
	                 
	                 
	                // 画像のサイズを先にとってくる
	                BitmapFactory.Options options = new BitmapFactory.Options();
	                // これtrueにすると、画像のデータは読み込まない
	                options.inJustDecodeBounds = true;
	                 
	                // 画像の情報だけ先取り
	                BitmapFactory.decodeFile(filePath, options);
	                 
	                // 画像の情報
	                int srcWidth = options.outWidth;
	                int srcHeight = options.outHeight;
	 
	                // ベースのサイズ
	                int baseWidth = 256;
	                 
	                // 幅の大きい方に合わせる
	                if (srcWidth < srcHeight) {
	                    options.inSampleSize = srcHeight / baseWidth;
	                } else {
	                    options.inSampleSize = srcWidth / baseWidth;
	                }
	                 
	                 
	                // 今度はデータも取ってくる
	                options.inJustDecodeBounds = false;
	 
	                // Bitmap ソースの読み込み
	                Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
	                 
	 
	                // テキストビューに画像サイズを設定する
	        //        TextView tv = (TextView)this.findViewById(R.id.textView1);
	 //               tv.setText(srcWidth + " x " + srcHeight);
	                 
	                // 画像表示用Viewに表示する
	                final ImageView iv = (ImageView)this.findViewById(R.id.imageView1);
	                iv.setImageBitmap(bitmap);
	 
	                 
	                // Bitmapをリサイズする
	                Bitmap tmp = makeBitmap(bitmap, baseWidth);
	                 
	                // アプリケーション領域に保存する
	                this.savePictureToLocal("test.png", tmp);
	 
	                 
	                 
	                // ローカル領域に保存したファイルを読み込む
	                //
	                 
	                // 保存したPNGをロード
	                Bitmap png = this.loadPictureFromLocal("test.png");
	                 
	 
	                // テキストビューにリサイズ後の画像サイズを設定する
	         //       tv = (TextView)this.findViewById(R.id.textView2);
	           //   tv.setText(png.getWidth() + " x " + png.getHeight());
	 
	                // 変更したBmp表示用View
	            //    final ImageView iv2 = (ImageView)this.findViewById(R.id.imageView2);
	              //  iv2.setImageBitmap(png);
	            }
	        }
	        // TODO 自動生成されたメソッド・スタブ
	        super.onActivityResult(requestCode, resultCode, data);
	    }
	     
	    // ______________________________________________________________________________
	    /**
	     * Bitmapの内容を指定のサイズにリサイズする
	     * @param src 元のBitmap
	     * @param size 縦横サイズ(同じサイズ)
	     * @return
	     */
	    public Bitmap makeBitmap(Bitmap src, int size) {
	         
	        Matrix m = new Matrix();
	         
	        // Bitmapのサイズ
	        int w = src.getWidth();
	        int h = src.getHeight();
	         
	        // 拡大率
	        float scale = 1.0f;
	         
	        if (w < h) {
	            scale = (float)size / h;
	        } else {
	            scale = (float)size / w;
	        }
	 
	        m.setScale(scale, scale);
	         
	         
	        // 縦横を指定されたsizeの画像を作る
	        Bitmap dest = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
	         
	        // キャンバスにセットしてそこに画像を書き込む形で新しい画像を作る
	        Canvas canvas = new Canvas(dest);
	        canvas.drawColor(0xffff00ff);
	     
	        // リサイズされたBitmapのサイズ
	        int rw = (int)((float)w * scale);
	        int rh = (int)((float)h * scale);
	                 
	        int offsetX = (size / 2) - (rw / 2);
	        int offsetY = (size / 2) - (rh / 2);
	         
	         
	        Paint paint = new Paint();
	        paint.setFilterBitmap(true);
	        m.postTranslate(offsetX, offsetY);
	        canvas.drawBitmap(src, m, paint);
	         
	        return dest;
	    }
	     
	 
	    // ______________________________________________________________________________
	    /**
	     * 画像をアプリのプライベート領域に保存する
	     * @param name ファイル名
	     */
	    public void savePictureToLocal(String name, Bitmap bmp) {
	         
	        try {
	            // アプリ領域をのファイルを開く
	            OutputStream os = this.openFileOutput(name, MODE_PRIVATE);
	            bmp.compress(Bitmap.CompressFormat.PNG, 100, os);
	             
	        } catch (FileNotFoundException e) {
	            // TODO 自動生成された catch ブロック
	            e.printStackTrace();
	        }
	         
	    }
	     
	    // ______________________________________________________________________________
	    /**
	     * 画像ファイルを読み込む
	     * @param name 名前
	     * @return 読み込んだ画像
	     */
	    public Bitmap loadPictureFromLocal(String name) {
	         
	        InputStream is = null;
	        Bitmap res = null;
	         
	        try {
	            // ファイルからPNGファイルを読み込む
	            is = this.openFileInput(name);
	            res = BitmapFactory.decodeStream(is);
	            is.close();
	             
	        } catch (FileNotFoundException e) {
	            // TODO 自動生成された catch ブロック
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO 自動生成された catch ブロック
	            e.printStackTrace();
	        }
	         
	        return res;
	         
	    }

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	 
	}

	
	
	
		
			
	
	
	
	
	
	/*
		@Override
		protected void onResume() {
			// TODO 自動生成されたメソッド・スタブ
			super.onResume();
			Button btnRELATIVE = (Button)findViewById(R.id.modoru);
		btnRELATIVE.setOnClickListener(this);
		}	
		
		
		@Override
public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			Intent intent = null;
			switch(v.getId()) { //どのボタンが押されたか判定
				case R.id.modoru: // LinearLayoutボタンが押された

					// インテントのインスタンス生成
					intent = new Intent(Draw.this, Menu.class);
					break;
		}
			startActivity(intent);
		}

	}
*/
