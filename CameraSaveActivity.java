package com.example.anurag_pc.shreyafinalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.anurag_pc.shreyafinalproject.BaseActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraSaveActivity extends BaseActivity {

    private static final String TAG = "Camera";

    private static final int CAMERA_PIC_REQUEST = 1111;
    Button get , save;
    ImageView image;
    String to_send;
    String filename;
    private File outFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_save);

        image = (ImageView)findViewById(R.id.image);

        get = (Button)findViewById(R.id.bt1_get);//click

        save = (Button)findViewById(R.id.bt1_save);//share

        get.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, CAMERA_PIC_REQUEST);

            }
        });

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                BitmapDrawable bitmapDrawable = (BitmapDrawable)image.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                // Save this bitmap to a file.
                File cache = getApplicationContext().getExternalCacheDir();
                File sharefile = new File(cache, "toshare.png");
                try {
                    FileOutputStream out = new FileOutputStream(sharefile);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                }

                // Now send it out to share
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("image/*");
                share.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + sharefile.getAbsolutePath()));
                try {
                    startActivity(Intent.createChooser(share, "Share photo"));
                } catch (Exception e) {
                }
                 /*Intent share = new Intent(Intent.ACTION_SEND);
                 share.setType("text/plain");
                 //String to_send = null;
                share.putExtra(Intent.EXTRA_TEXT, to_send);

                 startActivity(Intent.createChooser(share, "Share using..."));*/

            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        FileOutputStream outStream = null;
        if (requestCode == CAMERA_PIC_REQUEST) {
            //2
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(thumbnail);
            //3
            save.setVisibility(View.VISIBLE);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            //4
            try {
                File sdCard = Environment.getExternalStorageDirectory();
                File dir = new File(sdCard.getAbsolutePath() + "/MyPersonalFolder");
                dir.mkdirs();
                String fileName = String.format("%d.jpg", System.currentTimeMillis());
                File outFile = new File(dir, fileName);

                outStream = new FileOutputStream(outFile);
                //outStream.write(data[0]);
                outStream.flush();
                outStream.close();

                //Log.d(TAG, "onPictureTaken - wrote bytes: " + data.length + " to " + outFile.getAbsolutePath());

                refreshGallery(outFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {


                try {
                    outStream = new FileOutputStream(outFile);
                    outStream.write(bytes.toByteArray()); //this is the line you had missing
                    outStream.flush();
                    outStream.close();
                    //5
                    outStream.write(bytes.toByteArray());
                    outStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }
            }
        }
    }

    private void refreshGallery(File file) {
        Intent mediaScanIntent = new Intent( Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(Uri.fromFile(file));
        sendBroadcast(mediaScanIntent);
    }

    public static void addToGallery(Context context, String path) {
        MediaScanner scanner = new MediaScanner(path, null);
        MediaScannerConnection connection = new MediaScannerConnection(context, scanner);
        scanner.connection = connection;
        connection.connect();
    }

    /**
     * Scans the sd card for new videos/images and adds them to the gallery
     */
    private static final class MediaScanner implements MediaScannerConnection.MediaScannerConnectionClient {
        private final String path;
        private final String mimeType;
        MediaScannerConnection connection;

        public MediaScanner(String path, String mimeType) {
            this.path = path;
            this.mimeType = mimeType;
        }

        @Override
        public void onMediaScannerConnected() {
            connection.scanFile(path, mimeType);
        }

        @Override
        public void onScanCompleted(String path, Uri uri) {
            connection.disconnect();
        }
    }

}