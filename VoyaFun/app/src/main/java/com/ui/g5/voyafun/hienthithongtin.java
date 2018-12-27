package com.ui.g5.voyafun;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class hienthithongtin extends AppCompatActivity {

    TextView gioithieu, trochoi,lehoi, thamquan;
    ImageView trangchu;
    WebView webView;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthithongtin);

        webView = (WebView) findViewById(R.id.webViewHienThi);
        bar=(ProgressBar) findViewById(R.id.progressBar2);

        webView.setWebViewClient(new hienthithongtin.myWebclient());
        webView.getSettings().setJavaScriptEnabled(true);

        Bundle bundle = getIntent().getExtras();
        int Id = bundle.getInt("ID");
        String key = bundle.getString("Key");

        HienThi(key, Id);

        Anhxa();

        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Trangchu();
            }
        });

        lehoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lehoi();
            }
        });

        trochoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Trochoi();
            }
        });

        thamquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thamquan();
            }
        });

        gioithieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gioithieu();
            }
        });

    }

    public void HienThi(String key, int id) {
        if(key.equals("TQ") == true) {
            if(id == 1) {
                webView.loadUrl("http://www.suoitien.com/tham-quan/van-hoa-lich-su/tuong-dai-thanh-giong-1");
            }
            if(id ==2) {
                webView.loadUrl("http://www.suoitien.com/tham-quan/van-hoa-lich-su/tuong-dai-hai-ba-trung-1");
            }

            Toast.makeText(hienthithongtin.this,id +", " + key,Toast.LENGTH_SHORT).show();

        }

        else if(key.equals("LH") == true) {
            if(id == 1) {
                webView.loadUrl("http://www.suoitien.com/le-hoi/le-hoi-mua-xuan/tet-mau-tuat-2018-vui-tet-suoi-tien--phuc-tai-nhu-y-1");
            }
            if(id ==2) {
                webView.loadUrl("http://www.suoitien.com/le-hoi/le-hoi-mua-xuan/suoi-tien-uu-dai-dac-biet-nhan-ngay-quoc-te-phu-nu-08032018");
            }
            if(id == 3) {
                webView.loadUrl("http://www.suoitien.com/le-hoi/le-hoi-mua-xuan/gio-to-hung-vuong-tai-suoi-tien-noi-hoi-tu-ngan-nam-van-hien");
            }
            if(id ==4) {
                webView.loadUrl("http://www.suoitien.com/le-hoi/le-hoi-mua-xuan/xuan-dinh-dau-vui-tet-suoi-tien-chao-xuan-don-phuc");
            }

            Toast.makeText(hienthithongtin.this,id +", " + key,Toast.LENGTH_SHORT).show();

        }

        else if(key.equals("CGM") == true) {
            if(id == 1) {
                webView.loadUrl("http://www.suoitien.com/tro-choi/tro-choi-cam-giac-manh/tau-luon-sieu-toc-mini-1");
            }
            if(id ==2) {
                webView.loadUrl("http://www.suoitien.com/tro-choi/tro-choi-cam-giac-manh/xe-vuot-dia-hinh-1");
            }
            Toast.makeText(hienthithongtin.this,id +", " + key,Toast.LENGTH_SHORT).show();

        }

        else if(key.equals("KPPL") == true) {
            if(id == 1) {
                webView.loadUrl("http://www.suoitien.com/tro-choi/kham-pha-phieu-luu/dai-cung-phung-hoang-tien-1");
            }
            if(id ==2) {
                webView.loadUrl("http://www.suoitien.com/tro-choi/kham-pha-phieu-luu/dai-cung-lac-canh-tien-ngu-1");
            }

            Toast.makeText(hienthithongtin.this,id +", " + key,Toast.LENGTH_SHORT).show();

        }

        else if(key.equals("CTM") == true) {
            if(id == 1) {
                webView.loadUrl("http://www.suoitien.com/tro-choi/cac-cong-trinh-moi/bien-tien-dong-ngoc-nu");
            }
            Toast.makeText(hienthithongtin.this,id +", " + key,Toast.LENGTH_SHORT).show();


        }
    }

    private void Anhxa() {
        gioithieu   = (TextView)findViewById(R.id.txtGioithieu);
        trangchu    = (ImageView) findViewById(R.id.home);
        trochoi     = (TextView)findViewById(R.id.txtTrochoi);
        lehoi     = (TextView)findViewById(R.id.txtLehoi);
        thamquan    = (TextView)findViewById(R.id.txtThamquan);

    }

    public void Gioithieu() {
        Intent intent = new Intent(this, Gioithieu.class);
        startActivity(intent);
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
