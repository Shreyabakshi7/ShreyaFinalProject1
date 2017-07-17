package com.example.anurag_pc.shreyafinalproject;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.anurag_pc.shreyafinalproject.dialog.CustomDialog;
import com.example.anurag_pc.shreyafinalproject.fragment.DemoFragment;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_tv)
    TextView textView;

    Button btn_song;

    @OnClick(R.id.main_bt_login)
    public void login(View view)
    {
        CustomDialog customDialog = new CustomDialog(this, new CustomDialog.ICustomDialogListener() {

            @Override
            public void onOKClicked(String msg) {
                shortToast(msg);

            }
        });
        customDialog.setCanceledOnTouchOutside(true);
        customDialog.show();
    }
    @OnClick(R.id.main_bt_aboutApp)
    public void myapp(View view)
    {
        Intent i=new Intent(MainActivity.this, ViewPagerActivity.class);
        startActivity(i);


    }

    @OnClick(R.id.main_bt_myBill)
    public void myBill(View view)
    {
        Intent intent= new Intent(MainActivity.this, CameraActivity.class);
         startActivity(intent);
    }

    @OnClick(R.id.main_bt_myList)
    public void myList(View view)
    {
        Intent intent= new Intent(MainActivity.this, ListViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.main_bt_broad_service)
    public void broad_service(View view)
    {
        Intent intent= new Intent(MainActivity.this, BroadcastActivity.class); // this is saving file in directory
        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        btn_song =(Button)findViewById(R.id.main_bt_song);
//        MediaPlayer player = new MediaPlayer();
//        String media_path= "sdcard/Song.mp3";
//        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
//
//        Uri uri = Uri.parse(media_path);
//
//        try{
//            player.setDataSource(getApplicationContext(),uri);
//            player.prepare();
//            player.start();
//            shortToast("Playback started");
//            btn_song.setEnabled(false);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //layer.setOnCompletionLstener(new MediaPlayer.onCompletion)

    }
}
