package com.example.anurag_pc.shreyafinalproject;

import android.graphics.Bitmap;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CamDisplayActivity extends AppCompatActivity {

    @BindView(R.id.trial_cam_iv)
    ImageView iv;
    private Parcelable bMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_display);
        ButterKnife.bind(this);

        bMap =  getIntent().getParcelableExtra("image");
        iv.setImageBitmap((Bitmap) bMap);
    }
}
