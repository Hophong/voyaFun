package com.ui.g5.voyafun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Thamquan extends AppCompatActivity {

    TextView gioithieu, lehoi, trochoi;
    ImageView trangchu;
    ListView lvThamquan;
    ArrayList<Information> arrThamquan;
    customAdapter myAdapter;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thamquan);

        Anhxa();

        Khoitaodulieu();

        myAdapter = new customAdapter(this, R.layout.custom_row, arrThamquan);
        lvThamquan.setAdapter(myAdapter);

        lvThamquan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int Id;
                Information diadiem = arrThamquan.get(position);
                Bundle bundle = new Bundle();
                Intent intent = new Intent(Thamquan.this,hienthithongtin.class);
                Id = diadiem.getId();
                bundle.putInt("ID",Id);
                bundle.putString("Key", "TQ");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Trangchu();
            }
        });

        trochoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Trochoi();
            }
        });

        lehoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lehoi();
            }
        });

        gioithieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gioithieu();
            }
        });
    }

    private void Anhxa() {
        trangchu = (ImageView) findViewById(R.id.home);
        gioithieu = (TextView) findViewById(R.id.txtGioithieu);
        lehoi = (TextView) findViewById(R.id.txtLehoi);
        trochoi = (TextView) findViewById(R.id.txtTrochoi);
        lvThamquan = (ListView)findViewById(R.id.listThamquan);
    }

    private  void Khoitaodulieu() {
        arrThamquan = new ArrayList<>();
        arrThamquan.add(new Information(1, R.drawable.tg, "Tượng đài Thánh Gióng"));
        arrThamquan.add(new Information(2, R.drawable.hbt, "Tượng Đài Hai Bà Trưng"));
    }

    public void Trangchu() {
        Intent myHome = new Intent(this, MainActivity.class);
        startActivity(myHome);
    }

    public void Gioithieu() {
        Intent intent = new Intent(this, Gioithieu.class);
        startActivity(intent);
    }

    public void Trochoi() {
        Intent game = new Intent(this, trochoi.class);
        startActivity(game);
    }

    public void Lehoi() {
        Intent myFestival = new Intent(this, lehoi.class);
        startActivity(myFestival);
    }


}
