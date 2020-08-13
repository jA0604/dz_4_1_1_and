package com.androidakbar.dz_4_1_1_and;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        appToolbar.setTitle(R.string.name_dz);
        appToolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryText));

        List<Map<String, String>> content = new ArrayList<>();
        String[] txt = getResources().getStringArray(R.array.sa_description);
        for (String s : txt) {
            Map<String, String> iRow = new HashMap<>();
            iRow.put("description", s);
            iRow.put("num_letters", String.valueOf(s.length()));
            content.add(iRow);
        }

        String[] from = new String[]{"description", "num_letters"};
        int[] to = new int[]{R.id.txt_description, R.id.txt_num_letters};
        SimpleAdapter simAdapter = new SimpleAdapter(this, content, R.layout.list_item, from, to);

        ListView lstView = findViewById(R.id.lst_view);
        lstView.setAdapter(simAdapter);

    }


}