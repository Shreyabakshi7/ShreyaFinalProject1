

        package com.example.anurag_pc.shreyafinalproject;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.database.Cursor;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.net.Uri;
        import android.os.Environment;
        import android.os.Message;
        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.ByteArrayOutputStream;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.io.InputStream;
        import java.net.URI;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import butterknife.OnClick;

public class CameraActivity extends BaseActivity {
    private final int DIALOG=12345;
    public static final int IMAGE_GALLERY_REQUEST= 20;

    android.os.Handler mhandler= new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    shortToast(s);
                    break;
                default:
            }
            super.handleMessage(msg);


        }
    };

    @BindView(R.id.camera_tv)
    TextView textView;

    @BindView(R.id.camera_iv)
    ImageView imageView;

    @BindView(R.id.camera_bt_open_camera)
    Button open_cam;

    @BindView(R.id.camera_bt_current_save)
    Button curr_img;

    @OnClick(R.id.camera_bt_saved_bills)
    public void saved_bill(View view){
        Intent intent= new Intent(CameraActivity.this,ZoomActivity .class);
        startActivity(intent);
    }

    private int CAMERA_REQUEST;


    @OnClick(R.id.camera_bt_upload)
    public void upload(View view)
    {
        progressDialog();}

    static Uri capturedImageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);

        open_cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                open_cam.setOnClickListener(new View.OnClickListener() {
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


        });




        curr_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(CameraActivity.this, SDCardActivity.class); // this is saving file in directory
                startActivity(intent);

            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST){
                Uri imageUri = data.getData();
                InputStream inputstream;
                try{

                    inputstream= getContentResolver().openInputStream(imageUri);
                    Bitmap image = BitmapFactory.decodeStream(inputstream);
                    imageView.setImageBitmap(image);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    shortToast("Unable to open image");
                }

            }

        }
    }



    private void progressDialog() {

        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Uploading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;

                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                Bundle bundle= new Bundle();
                bundle.putString("msg","Bill Uploaded Successfully");
                Message msg= Message.obtain();
                msg.what=DIALOG;
                msg.setData(bundle);

                mhandler.sendMessage(msg);
                progressDialog.cancel();

            }

        }).start();

    }

    ProgressDialog waitingDialog;

}
