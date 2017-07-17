package com.example.anurag_pc.shreyafinalproject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraTrialActivity extends AppCompatActivity {


    @BindView(R.id.trial_cam_bt)
    Button bt1;
    private Uri mImageCaptureUri;
    static final int CAM_REQUEST=1;
    private static final int PICK_FROM_CAMERA = 1111;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_trial);
        ButterKnife.bind(this);
        bt1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent cam_Intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //File file = getFile();
                //cam_Intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
                //startActivityForResult(cam_Intent,CAM_REQUEST);
                mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
                        "image" + String.valueOf(System.currentTimeMillis()) + ".jpg"));
                try {
                    startActivityForResult(cam_Intent, PICK_FROM_CAMERA);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }


        });
    }
    private File getFile(){

        File folder= new File ("sdcard/camera_app");
        if(!folder.exists())
        {
            folder.mkdir();
        }
        File image_file= new File(folder,"cam_image.jpg");
        return image_file;

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) return;
        switch (requestCode) {
            case PICK_FROM_CAMERA:
                Bitmap photo = null;
                Bundle extras = data.getExtras();
                if (extras != null) {
                    photo = extras.getParcelable("data");
                }
                Intent i = new Intent(this, CamDisplayActivity.class);
                i.putExtra("image", photo);
                startActivity(i);
                break;
        }
    }
}
