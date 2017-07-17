package com.example.anurag_pc.shreyafinalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.anurag_pc.shreyafinalproject.R.id.image;

public class ShowImagesActivity extends AppCompatActivity {

    @BindView(R.id.show_image_iv)
    ImageView imageView;
    private Animation animSlide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_images);
        ButterKnife.bind(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lefttoright();
                righttoleft();
            }
        });
    }
        public void lefttoright() {
            TranslateAnimation animation1 = new TranslateAnimation(0, 600, 0, 0);//new TranslateAnimation(xFrom,xTo, yFrom,yTo)
            animation1.setDuration(1000);
            imageView.startAnimation(animation1);
        }

        public void righttoleft() {
            TranslateAnimation animation2 = new TranslateAnimation(300, 0, 0, 0);//new TranslateAnimation(xFrom,xTo, yFrom,yTo)
            animation2.setDuration(1000);
            imageView.startAnimation(animation2);
        }
//        animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.slide_left);
//        imageView.startAnimation(animSlide);
//        TranslateAnimation anim = new TranslateAnimation(-500, 50, 50, 50);
//        anim.setDuration(1000);
//        anim.setFillAfter(true);
//        imageView.startAnimation(anim);
//        imageView.setImageResource(R.drawable.tick1);
//    }
}
