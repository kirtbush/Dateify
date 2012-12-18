package com.kutmastak.dateify;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.kutmastak.dateify.*;

public class DateifyActivity extends Activity {
    private static final int CAMERA_REQUEST = 1888; 
    private ImageView imageView;	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateify);
        
        this.imageView = (ImageView)this.findViewById(R.id.imageView1);
        Button imageButton = (Button)findViewById(R.id.TakeImageButton);
        imageButton.setOnClickListener(mPhotoListener);
        Button scanButton = (Button)findViewById(R.id.ScanButton);
        scanButton.setOnClickListener(mScanListener);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_imagesource, menu);
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
            imageView.setImageBitmap(photo);
        }  
    }    
    
    private OnClickListener mCancelListener = new OnClickListener() {
		
		public void onClick (View v) {
			// TODO Auto-generated method stub
			Log.i("INPUTS","Clicked Cancel2MainButton");
			Intent changeIntent = new Intent(getBaseContext(), DateifyActivity.class);
			startActivity(changeIntent);
		}
	};
    private OnClickListener mPhotoListener = new OnClickListener() {
		
		public void onClick (View v) {
			// TODO Auto-generated method stub
			Log.i("INPUTS","Clicked TakeImageButton");
			Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
          	startActivityForResult(cameraIntent, CAMERA_REQUEST);
		}
	};
	
    private OnClickListener mScanListener = new OnClickListener() {
		
		public void onClick (View v) {
			// TODO Auto-generated method stub
			Log.i("INPUTS","Clicked TakeImageButton");
			Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
          	startActivityForResult(cameraIntent, CAMERA_REQUEST);
		}
	};	
}
