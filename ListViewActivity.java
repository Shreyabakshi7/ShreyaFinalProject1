package com.example.anurag_pc.shreyafinalproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anurag_pc.shreyafinalproject.adapter.CustomAdapter;
import com.example.anurag_pc.shreyafinalproject.fragment.ListNormalAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends BaseActivity implements AdapterView.OnItemClickListener {

//    @BindView(R.id.activity_lv)
//    ListView mylistview;
    String[] shop_names;
    TypedArray shop_pic;
    String[] shop_type;
    List<RowItem> rowItems ;
    ListView mylistview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
//        ButterKnife.bind(this);
//
//        String[] items= {"item1","item2","item3","item4","item5"};
//        ListAdapter myadapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
//        mylistview.setAdapter(myadapter);
//
//        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String items= String.valueOf(parent.getItemAtPosition(position));
//                shortToast(items);
//            }
//        });
//
        rowItems = new ArrayList<RowItem>();

        shop_names = getResources().getStringArray (R.array.Shop_Names);

        shop_pic = getResources().obtainTypedArray (R.array.Shop_Pics);

        shop_type = getResources().getStringArray (R.array.Shop_Types);

        for (int i = 0; i< shop_names.length; i++)
        {
            RowItem item = new RowItem (shop_names[i] ,
                    shop_pic.getResourceId(i,-1), shop_type[i]);
            rowItems.add(item);


        }
        mylistview= (ListView) findViewById(R.id.activity_lv);
        CustomAdapter adapter = new CustomAdapter (this, rowItems);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(this);
  }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String shop_name = rowItems.get(position).getshop_name();
        Toast.makeText(getApplicationContext(), "" + shop_name,Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(ListViewActivity.this, CreateListActivity.class);
        startActivity(intent);

    }
}

