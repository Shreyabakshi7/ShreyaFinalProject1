package com.example.anurag_pc.shreyafinalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckBoxActivity extends BaseActivity {

    private HashMap<String, Boolean> list = new HashMap<String, Boolean>();


    @BindView(R.id.activity_check_box_1)
    CheckBox checkbox1;

    @BindView(R.id.activity_check_box_2)
    CheckBox checkbox2;

    @BindView(R.id.activity_check_box_3)
    CheckBox checkbox3;

    @BindView(R.id.activity_check_box_4)
    CheckBox checkbox4;

    @BindView(R.id.activity_check_box_5)
    CheckBox checkbox5;

    @BindView(R.id.activity_check_box_6)
    CheckBox checkbox6;

    @BindView(R.id.activity_check_box_7)
    CheckBox checkbox7;

    @BindView(R.id.activity_check_box_8)
    CheckBox checkbox8;

    @BindView(R.id.activity_check_box_9)
    CheckBox checkbox9;

    @OnClick(R.id.activity_check_box_save)
    public void submit(View view) {
        String s = "You checked: ";
        for (Map.Entry<String, Boolean> entry : list.entrySet()) {
            if (entry.getValue()) {
                s = s + "  " + entry.getKey();
            }
        }
        shortToast(s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ButterKnife.bind(this);

        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });
        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });
        checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });

        checkbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });
        checkbox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });
        checkbox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });

        checkbox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(),isChecked);
            }
        });
        checkbox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });
        checkbox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.put(buttonView.getText().toString(), isChecked);
            }
        });
    }
}
