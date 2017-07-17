package com.example.anurag_pc.shreyafinalproject;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anurag_pc.shreyafinalproject.service.TestService;

import static com.example.anurag_pc.shreyafinalproject.R.id.textView;

public class BroadcastActivity extends AppCompatActivity {

    private NotificationManager manager;
    private TestReceiver testReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        manager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Button start = (Button)findViewById(R.id.service_start);
        Button stop = (Button)findViewById(R.id.service_stop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadcastActivity.this, TestService.class);
                intent.putExtra("Service","Start");
                startService(intent);
                registerBroadcast();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BroadcastActivity.this, TestService.class);
                stopService(intent);
            }
        });

    }

    private void registerBroadcast() {
        testReceiver= new TestReceiver();
        IntentFilter filter= new IntentFilter();
        filter.addAction(TestService.ACTION);
        registerReceiver(testReceiver,filter);
    }
    public class TestReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action= intent.getAction();
            if(action.equals(TestService.ACTION)){
                int update= intent.getIntExtra("update",0);
                //textView.setText(String.valueOf(update));
            }
        }
    }
}
