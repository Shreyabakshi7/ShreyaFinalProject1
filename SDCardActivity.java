package com.example.anurag_pc.shreyafinalproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SDCardActivity extends AppCompatActivity {

    @BindView(R.id.SD_card_imageView)
    ImageView iv;

    private static final int WRITE_PERMISSION = 0x01;
    private String LOG_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);
        ButterKnife.bind(this);
        //requestWritePermission();

        ImageView jpgView = (ImageView)findViewById(R.id.SD_card_imageView);
        Bitmap bitmap = BitmapFactory.decodeFile("sdcard/camera_app/cam_image.jpg");
        jpgView.setImageBitmap(bitmap);

    }








//        @Override
//        public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//            if(requestCode == WRITE_PERMISSION){
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Log.d(LOG_TAG, "Write Permission Failed");
//                    Toast.makeText(this, "You must allow permission write external storage to your mobile device.", Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//            }
//        }
//
//        private void requestWritePermission(){
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},WRITE_PERMISSION);
//                }
//            }
//        }

//        String storageDir = Environment.getExternalStorageDirectory().getAbsolutePath();
//        String fileName = "cam_image.jpg";
//        File imageFile= new File(storageDir+fileName);
//        try {
//            OutputStream output = new FileOutputStream(imageFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        String path = Environment.getExternalStorageDirectory()+ "sdcard/camera_app/cam_image.jpg";
//                File imgFile = new File(path);
//                if(imgFile.exists())
//                {
//                    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//                    ImageView myImage = (ImageView) findViewById(R.id.SD_card_imageView);
//                    myImage.setImageBitmap(myBitmap);
//                }
////                else
//                    Toast.makeText(v.getContext(),"no IMAGE IS PRESENT'", Toast.LENGTH_SHORT).show();
//            }
    }

