package com.example.mymp3player;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView_casi;
    ArrayList<list_casi> list_casi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_casi = (ListView) findViewById(R.id.list_casi);

        list_casi = new ArrayList<list_casi>();

        list_casi.add(new list_casi("Chi Dan",R.drawable.chi_dan));
        list_casi.add(new list_casi("Mr Siro",R.drawable.mr_siro));
        list_casi.add(new list_casi("Ngô Kiến Huy",R.drawable.ngo_kien_huy));
        list_casi.add(new list_casi("Đan Nguyên",R.drawable.dan_nguyen));
        list_casi.add(new list_casi("Quang Lê",R.drawable.quang_le));
        list_casi.add(new list_casi("Trường Vũ", R.drawable.truong_vu));
        list_casi.add(new list_casi("Minh Vương M4U", R.drawable.minh_vuong_m4u)  );

        Adapter_casi adapter_casi = new Adapter_casi(MainActivity.this, R.layout.list_ca_si, list_casi);

        listView_casi.setAdapter(adapter_casi);

        listView_casi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, activity_bai_hat.class);
                intent.putExtra("position", position);
                intent.putExtra("tencasi", list_casi.get(position).ten_casi);







                startActivity(intent);
            }
        });

    }
}

