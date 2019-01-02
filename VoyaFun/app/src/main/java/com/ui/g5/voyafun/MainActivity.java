package com.ui.g5.voyafun;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView gioithieu, lehoi, trochoi, thamquan, tinnhan;
    ImageView dienthoai;
    Button datve;
    WebView webView;
    ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        gioithieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gioithieu();
            }
        });

        datve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatveOnline();
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

        thamquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thamquan();
            }
        });

        dienthoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog();
            }

            private void ShowDialog() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Suoitien.com");
                builder.setMessage("Bạn có muốn liên hệ tổng đài viên không?");
                builder.setCancelable(false);
                builder.setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String posted_by = "0355729988";

                        String uri = "tel:" + posted_by.trim();
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse(uri));

                        startActivity(intent);
                    }
                });
                builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        tinnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tinnhan();
            }

            public void Tinnhan() {
                Intent myBooking = new Intent(MainActivity.this, tinnhan.class);
                startActivity(myBooking);
            }
        });



        webView.setWebViewClient(new MainActivity.myWebclient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.suoitien.com/");

    }

    private void Anhxa() {
        gioithieu   = (TextView)findViewById(R.id.txtGioithieu);
        lehoi       = (TextView)findViewById(R.id.txtLehoi);
        trochoi     = (TextView)findViewById(R.id.txtTrochoi);
        thamquan    = (TextView)findViewById(R.id.txtThamquan);
        datve       = (Button)findViewById(R.id.btnDatve);
        webView     = (WebView) findViewById(R.id.webViewHienThi);
        bar         =(ProgressBar) findViewById(R.id.progressBar2);
        tinnhan     =(TextView)findViewById(R.id.txtTinnhan);
        dienthoai   =(ImageView)findViewById(R.id.imgDienthoai);

    }

    public void DatveOnline() {
        Intent myBooking = new Intent(this, Datve.class);
        startActivity(myBooking);
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

    public void Thamquan() {
        Intent myVisit = new Intent(this, Thamquan.class);
        startActivity(myVisit);
    }

    public class myWebclient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            bar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
