package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        SharedPreferences.Editor editor = sharedPreferences.edit();
        View view = inflater.inflate(R.layout.fragment_save,null);
        TextView textView1,textView2,textView3,textView4,textView5,textView6;

        Button btn1,btn2,btn3;
        textView1 = (TextView) view.findViewById(R.id.level1);
        textView2 = (TextView) view.findViewById(R.id.money1);
        textView3 = (TextView) view.findViewById(R.id.level2);
        textView4 = (TextView) view.findViewById(R.id.money2);
        textView5 = (TextView) view.findViewById(R.id.level3);
        textView6 = (TextView) view.findViewById(R.id.money3);
        btn1 = (Button) view.findViewById(R.id.btn_save1);
        btn2 = (Button) view.findViewById(R.id.btn_save2);
        btn3 = (Button) view.findViewById(R.id.btn_save3);

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
        btn1.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).btn_save();
                if (sharedPreferences.getInt("Save1_Level", 0) > 0) {
                    builder.setTitle("저장");
                    builder.setMessage("덮어쓰시겠습니까?");
                    builder.setNegativeButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editor.putInt("Save1_Level", sharedPreferences.getInt("Level", 0));
                            editor.putInt("Save1_money", sharedPreferences.getInt("money", 0));
                            editor.putInt("Save1_ch_Img", sharedPreferences.getInt("Character",0));
                            editor.putInt("Save1_difficulty",sharedPreferences.getInt("difficulty",0));
                            editor.commit();
                            textView1.setText(String.valueOf(sharedPreferences.getInt("Save1_Level", 0)));
                            textView2.setText(String.valueOf(sharedPreferences.getInt("Save1_money", 0)));
                            return;
                        }
                    });
                    builder.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });
                    builder.show();
                } else {
                    editor.putInt("Save1_Level", sharedPreferences.getInt("Level", 0));
                    editor.putInt("Save1_money", sharedPreferences.getInt("money", 0));
                    editor.putInt("Save1_ch_Img", sharedPreferences.getInt("Character",0));
                    editor.putInt("Save1_difficulty",sharedPreferences.getInt("difficulty",0));
                    editor.commit();
                    textView1.setText(String.valueOf(sharedPreferences.getInt("Save1_Level", 0)));
                    textView2.setText(String.valueOf(sharedPreferences.getInt("Save1_money", 0)));
                    return;
                }
            }
            });
        btn2.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).btn_save();
                if (sharedPreferences.getInt("Save2_Level", 0) > 0) {
                    builder.setTitle("저장");
                    builder.setMessage("덮어쓰시겠습니까?");
                    builder.setNegativeButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editor.putInt("Save2_Level", sharedPreferences.getInt("Level", 0));
                            editor.putInt("Save2_money", sharedPreferences.getInt("money", 0));
                            editor.putInt("Save2_ch_Img", sharedPreferences.getInt("Character",0));
                            editor.putInt("Save2_difficulty",sharedPreferences.getInt("difficulty",0));
                            editor.commit();
                            textView3.setText(String.valueOf(sharedPreferences.getInt("Save2_Level", 0)));
                            textView4.setText(String.valueOf(sharedPreferences.getInt("Save2_money", 0)));
                            return;
                        }
                    });
                    builder.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });
                    builder.show();
                } else {
                    editor.putInt("Save2_Level", sharedPreferences.getInt("Level", 0));
                    editor.putInt("Save2_money", sharedPreferences.getInt("money", 0));
                    editor.putInt("Save2_ch_Img", sharedPreferences.getInt("Character",0));
                    editor.putInt("Save2_difficulty",sharedPreferences.getInt("difficulty",0));
                    editor.commit();
                    textView3.setText(String.valueOf(sharedPreferences.getInt("Save2_Level", 0)));
                    textView4.setText(String.valueOf(sharedPreferences.getInt("Save2_money", 0)));
                    return;
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).btn_save();
                if (sharedPreferences.getInt("Save3_Level", 0) > 0) {
                    builder.setTitle("저장");
                    builder.setMessage("덮어쓰시겠습니까?");
                    builder.setNegativeButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editor.putInt("Save3_Level", sharedPreferences.getInt("Level", 0));
                            editor.putInt("Save3_money", sharedPreferences.getInt("money", 0));
                            editor.putInt("Save3_ch_Img", sharedPreferences.getInt("Character",0));
                            editor.putInt("Save3_difficulty",sharedPreferences.getInt("difficulty",0));
                            editor.commit();
                            textView5.setText(String.valueOf(sharedPreferences.getInt("Save3_Level", 0)));
                            textView6.setText(String.valueOf(sharedPreferences.getInt("Save3_money", 0)));
                            return;
                        }
                    });
                    builder.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });
                    builder.show();
                } else {
                    editor.putInt("Save3_Level", sharedPreferences.getInt("Level", 0));
                    editor.putInt("Save3_money", sharedPreferences.getInt("money", 0));
                    editor.putInt("Save3_ch_Img", sharedPreferences.getInt("Character",0));
                    editor.putInt("Save3_difficulty",sharedPreferences.getInt("difficulty",0));
                    editor.commit();
                    textView5.setText(String.valueOf(sharedPreferences.getInt("Save3_Level", 0)));
                    textView6.setText(String.valueOf(sharedPreferences.getInt("Save3_money", 0)));
                    return;
                }
            }
        });

        return view;
    }

}