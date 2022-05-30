package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link save#newInstance} factory method to
 * create an instance of this fragment.
 */
public class save extends Fragment{
    ListView listView;
    List<String> list;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public save() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment save.
     */
    // TODO: Rename and change types and number of parameters
    public static save newInstance(String param1, String param2) {
        save fragment = new save();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("main", Context.MODE_PRIVATE);
        View view = inflater.inflate(R.layout.fragment_save,null);
        TextView textView1,textView2,textView3,textView4,textView5,textView6;
        textView1 = (TextView) view.findViewById(R.id.level1);
        textView2 = (TextView) view.findViewById(R.id.money1);
        textView3 = (TextView) view.findViewById(R.id.level2);
        textView4 = (TextView) view.findViewById(R.id.money2);
        textView5 = (TextView) view.findViewById(R.id.level3);
        textView6 = (TextView) view.findViewById(R.id.money3);
        if (sharedPreferences.getInt("Save1_Level",0) > 0){
            textView1.setText(String.valueOf(sharedPreferences.getInt("Save1_Level",0)));
            textView2.setText(String.valueOf(sharedPreferences.getInt("Save1_money",0)));
        }
        if (sharedPreferences.getInt("Save2_Level",0) > 0){
            textView3.setText(String.valueOf(sharedPreferences.getInt("Save2_Level",0)));
            textView4.setText(String.valueOf(sharedPreferences.getInt("Save2_money",0)));
        }
        if (sharedPreferences.getInt("Save3_Level",0) > 0){
            textView5.setText(String.valueOf(sharedPreferences.getInt("Save3_Level",0)));
            textView6.setText(String.valueOf(sharedPreferences.getInt("Save3_money",0)));
        }
        return view;
    }
}