package com.example.anurag_pc.shreyafinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateListActivity extends BaseActivity {

    @BindView(R.id.activity_createList_lv)
    ListView lv;

    @BindView(R.id.activity_createList_et)
    EditText et;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private AdapterView mylistview;

    @OnClick(R.id.activity_createList_bt_store)
    public void my_store(View view)
    {


        Intent intent= new Intent(CreateListActivity.this, CheckBoxActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);
        ButterKnife.bind(this);
        String[] items = {"Apple","Banana","Grapes"};


        arrayList = new ArrayList<>(Arrays.asList(items));
         adapter=new ArrayAdapter<String> (this,R.layout.todolist_item,R.id.createlist_tv,arrayList);
        lv.setAdapter(adapter);
       Button btadd = (Button)findViewById(R.id.activity_createList_bt_add);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = et.getText().toString();
                arrayList.add(newItem);
                adapter.notifyDataSetChanged();
                et.setText("");
            }
        });
    }
}
