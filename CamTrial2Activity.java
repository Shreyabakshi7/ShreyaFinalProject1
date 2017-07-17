package com.example.anurag_pc.shreyafinalproject;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.data;

public class CamTrial2Activity extends AppCompatActivity {

    @BindView(R.id.camera_bt1)
    Button bt1;

    @BindView(R.id.camera_iv)
    ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_trial2);
        ButterKnife.bind(this);

        bt1.setOnClickListener(new View.OnClickListener() {
            static final int CAM_REQUEST = 1;

            @Override
            public void onClick(View v) {
                Intent cam_Intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                cam_Intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(cam_Intent, CAM_REQUEST);
            }
        });
    }

    private File getFile() {

        File folder = new File("sdcard/camera_app");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File image_file = new File(folder, "cam_image.jpg");
        return image_file;

    }
}

//    private void createExternalStoragePublicPicture() {
//
//        File path = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//        File file = new File(path, "DemoPicture.jpg");
//
//        try {
//            // Make sure the Pictures directory exists.
//            path.mkdirs();
//
//            // Very simple code to copy a picture from the application's
//            // resource into the external file.  Note that this code does
//            // no error checking, and assumes the picture is small (does not
//            // try to copy it in chunks).  Note that if external storage is
//            // not currently mounted this will silently fail.
//           // InputStream is = getResources().openRawResource(R.drawable.bill1);
//            OutputStream os = new FileOutputStream(file);
//            //byte[] data = new byte[is.available()];
//            //is.read(data);
//            os.write(data);
//            //is.close();
//            os.close();
//
//            // Tell the media scanner about the new file so that it is
//            // immediately available to the user.
//            MediaScannerConnection.scanFile(this,
//                    new String[] { file.toString() }, null,
//                    new MediaScannerConnection.OnScanCompletedListener() {
//                        public void onScanCompleted(String path, Uri uri) {
//                            Log.i("ExternalStorage", "Scanned " + path + ":");
//                            Log.i("ExternalStorage", "-> uri=" + uri);
//                        }
//                    });
//        } catch (IOException e) {
//            // Unable to create file, likely because external storage is
//            // not currently mounted.
//            Log.w("ExternalStorage", "Error writing " + file, e);
//        }
//    }
//
//    void deleteExternalStoragePublicPicture() {
//        // Create a path where we will place our picture in the user's
//        // public pictures directory and delete the file.  If external
//        // storage is not currently mounted this will fail.
//        File path = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//        File file = new File(path, "DemoPicture.jpg");
//        file.delete();
//    }
//
//    boolean hasExternalStoragePublicPicture() {
//        // Create a path where we will place our picture in the user's
//        // public pictures directory and check if the file exists.  If
//        // external storage is not currently mounted this will think the
//        // picture doesn't exist.
//        File path = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//        File file = new File(path, "DemoPicture.jpg");
//        return file.exists();
//    }
//    }



    //---------------------Old Code creates directory in gallery---------------------------------------//

//        bt1.setOnClickListener(new View.OnClickListener() {
//            static final int CAM_REQUEST=1;
//
//            @Override
//            public void onClick(View v) {
//                Intent cam_Intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                File file = getFile();
//                cam_Intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
//                startActivityForResult(cam_Intent,CAM_REQUEST);
//            }
//        });
//    }
//
//    private File getFile(){
//
//        File folder= new File ("sdcard/camera_app");
//        if(!folder.exists())
//        {
//            folder.mkdir();
//        }
//        File image_file= new File(folder,"cam_image.jpg");
//        return image_file;
//
//    }


