package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link state#newInstance} factory method to
 * create an instance of this fragment.
 */
public class state extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public state() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment state.
     */
    // TODO: Rename and change types and number of parameters
    public static state newInstance(String param1, String param2) {
        state fragment = new state();
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
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("main", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_state,null);
        Button hp_btn = (Button) view.findViewById(R.id.HP_btn);
        Button atk_btn = (Button) view.findViewById(R.id.atk_btn);
        Button defence_btn = (Button) view.findViewById(R.id.defense_btn);
        Button luk_btn = (Button) view.findViewById(R.id.luk_btn);
        //button end
        TextView hp_textView = (TextView) view.findViewById(R.id.getHP);
        TextView atk_textView = (TextView) view.findViewById(R.id.getatk);
        TextView defence_textView = (TextView) view.findViewById(R.id.getdefense);
        TextView luk_textView = (TextView) view.findViewById(R.id.getluk);
        //text end
        hp_btn.setText(String.valueOf(sharedPreferences.getInt("HP_btn",1)));
        atk_btn.setText(String.valueOf(sharedPreferences.getInt("atk_btn",1)));
        defence_btn.setText(String.valueOf(sharedPreferences.getInt("defence_btn",1)));
        luk_btn.setText(String.valueOf(sharedPreferences.getInt("luk_btn",1)));
        //버튼 기본값 받아오기
        hp_textView.setText(String.valueOf(sharedPreferences.getInt("HP",100)));
        atk_textView.setText(String.valueOf(sharedPreferences.getInt("atk",10)));
        defence_textView.setText(String.valueOf(sharedPreferences.getInt("defence",0)));
        luk_textView.setText(String.valueOf(sharedPreferences.getInt("luk",0)));
        //텍스트 기본값 받아오기
        //버튼 이벤트 시작

        View.OnClickListener onClickListener = new View.OnClickListener() {
            int i, money;
            @Override
            public void onClick(View view) {
                money = sharedPreferences.getInt("money",0);
                i = 0;
                switch (view.getId()){
                    case R.id.HP_btn:
                        i = Integer.parseInt(hp_btn.getText().toString());
                        if (money >= i) {
                            money -= i;
                            i += 1;
                            hp_btn.setText(String.valueOf(i));
                            editor.putInt("HP_btn",i);
                            i = Integer.parseInt(hp_textView.getText().toString()) + 1;
                            hp_textView.setText(String.valueOf(i));
                            editor.putInt("HP",i);
                            editor.putInt("money",money);
                            editor.commit();
                        }
                        break;
                    case R.id.atk_btn:
                        i = Integer.parseInt(atk_btn.getText().toString());
                        if (money >= i) {
                            money -= i;
                            i += 1;
                            atk_btn.setText(String.valueOf(i));
                            editor.putInt("atk_btn",i);
                            i = Integer.parseInt(atk_textView.getText().toString()) + 1;
                            atk_textView.setText(String.valueOf(i));
                            editor.putInt("atk",i);
                            editor.putInt("money",money);
                            editor.commit();
                        }
                        break;
                    case R.id.defense_btn:
                        i = Integer.parseInt(defence_btn.getText().toString());
                        if (money >= i) {
                            money -= i;
                            i += 1;
                            defence_btn.setText(String.valueOf(i));
                            editor.putInt("defence_btn",i);
                            i = Integer.parseInt(defence_textView.getText().toString()) + 1;
                            defence_textView.setText(String.valueOf(i));
                            editor.putInt("defence",i);
                            editor.putInt("money",money);
                            editor.commit();
                        }
                        break;
                    case R.id.luk_btn:
                        i = Integer.parseInt(luk_btn.getText().toString());
                        if (money >= i) {
                            money -= i;
                            i += 1;
                            luk_btn.setText(String.valueOf(i));
                            editor.putInt("luk_btn",i);
                            i = Integer.parseInt(luk_textView.getText().toString()) + 1;
                            luk_textView.setText(String.valueOf(i));
                            editor.putInt("luk",i);
                            editor.putInt("money",money);
                            editor.commit();
                        }

                }
            }

        };
        hp_btn.setOnClickListener(onClickListener);
        atk_btn.setOnClickListener(onClickListener);
        defence_btn.setOnClickListener(onClickListener);
        luk_btn.setOnClickListener(onClickListener);
        return view;
    }



}