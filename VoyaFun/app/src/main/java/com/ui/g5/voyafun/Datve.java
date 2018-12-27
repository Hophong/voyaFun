package com.ui.g5.voyafun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Datve extends AppCompatActivity {

    TextView trangchu, lehoi, trochoi, thamquan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datve);
        // anh xa
        Anhxa();

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

        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Trangchu();
            }
        });

        thamquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thamquan();
            }
        });
    }

    private void Anhxa() {
        trangchu    = (TextView)findViewById(R.id.txtTrangchu);
        lehoi       = (TextView)findViewById(R.id.txtLehoi);
        trochoi     = (TextView)findViewById(R.id.txtTrochoi);
        thamquan    = (TextView)findViewById(R.id.txtThamquan);
    }

    public void Trangchu() {
        Intent myHome = new Intent(this, MainActivity.class);
        startActivity(myHome);
    }

    public void Trochoi() {
        Intent game = new Intent(this, trochoi.class);
        startActivity(game);
    }

    public void Lehoi() {
        Intent myFestival = new Intent(this, lehoi.class);
        startActivity(myFestival);
    }

    public void Thamquan() {
        Intent myVisit = new Intent(this, Thamquan.class);
        startActivity(myVisit);
    }
}
