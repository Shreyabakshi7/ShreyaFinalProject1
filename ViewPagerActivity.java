package com.example.anurag_pc.shreyafinalproject;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.anurag_pc.shreyafinalproject.adapter.BaseViewPagerAdapter;
import com.example.anurag_pc.shreyafinalproject.fragment.FifthFragment;
import com.example.anurag_pc.shreyafinalproject.fragment.FirstFragment;
import com.example.anurag_pc.shreyafinalproject.fragment.FourthFragment;
import com.example.anurag_pc.shreyafinalproject.fragment.SecondFragment;
import com.example.anurag_pc.shreyafinalproject.fragment.SixthFragment;
import com.example.anurag_pc.shreyafinalproject.fragment.ThirdFragment;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> list = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle", "onCreate");
        viewPager = (ViewPager) findViewById(R.id.activity_view_pager);
        list.add(new FirstFragment());
        list.add(new SecondFragment());
        list.add(new ThirdFragment());
        list.add(new FourthFragment());
        list.add(new FifthFragment());
        list.add(new SixthFragment());
        BaseViewPagerAdapter pagerAdapter = new BaseViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);
    }

    public ViewPagerActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "onRestart");


    }
}




