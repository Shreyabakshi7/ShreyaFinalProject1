package com.example.anurag_pc.shreyafinalproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.anurag_pc.shreyafinalproject.ListViewActivity;
import com.example.anurag_pc.shreyafinalproject.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DemoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final ArrayList<String> contentList;
    private ListView listView;


    public DemoFragment() {
        contentList= new ArrayList<String>();
        contentList.add("ViewPager");
        contentList.add("ImageScaleType");
        contentList.add("9Patch");
        contentList.add("Notification");
        contentList.add("AdvanceListView");
        contentList.add("AdvanceViewPager");
        contentList.add("LaunchMode");
        contentList.add("ActivityResult");
        contentList.add("RadioGroup");
        contentList.add("CheckBox");
        contentList.add("Dialog");
        contentList.add("Handler");
        contentList.add("Runnable");
        contentList.add("Animation");
        contentList.add("Animator");
        contentList.add("Gesture");
        contentList.add("SharedPreference");
        contentList.add("Service&Broadcast");
        contentList.add("Quiz2");
        contentList.add("TestAudioPlayer");
        contentList.add("AudioPlayer");
        // Required empty public constructor
    }


    public static DemoFragment newInstance(String param1, String param2) {
        DemoFragment fragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_demo, container, false);
        listView= (ListView)view.findViewById(R.id.fragment_demo_lv);
        ListNormalAdapter adapter= new ListNormalAdapter(this.getContext(),contentList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?>parent,View view ,int position,long id)
            {
                switch(position)
                {
                    case 0:
                        Intent intent= new Intent(getActivity(), ListViewActivity.class);
                        startActivity(intent);
                        break;

                    default:

                }
            }
        });

        return view;
    }


}

