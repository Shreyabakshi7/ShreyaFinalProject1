package com.example.anurag_pc.shreyafinalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZoomActivity extends BaseActivity {

    ScaleGestureDetector scaleGestureDetector;
    //private ImageView imageview;
    private float scale = 1f;

    @BindView(R.id.zoom_iv)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        ButterKnife.bind(this);

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        scaleGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener {
        float onScaleBegin = 0;
        float onScaleEnd = 0;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale = scale * detector.getScaleFactor();
            imageView.setScaleX(scale);
            imageView.setScaleY(scale);
            return true;
            //return false;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {

            shortToast("Zoom begins");
            onScaleBegin = scale;
            return true;

            //return false;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

            onScaleEnd = scale;
            if (onScaleEnd > onScaleBegin) {
                shortToast("Zoomed in by" + String.valueOf(onScaleEnd / onScaleBegin));
            } else if (onScaleEnd < onScaleBegin) {
                shortToast("Zoomed out by" + String.valueOf(onScaleBegin / onScaleEnd));

            }
        }
    }
}
