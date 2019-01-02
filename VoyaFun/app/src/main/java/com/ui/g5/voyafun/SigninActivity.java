package com.ui.g5.voyafun;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.lang.reflect.Method;
import java.util.ArrayList;

public class SigninActivity extends AppCompatActivity {
    ArrayList<User> arrayUser=new ArrayList<>();

    Button btnSignin;
    EditText edtUsername,edtPassword;
    TextView tvSignup, tvHaveAccount;

    String url_getdata = "https://nqphu1998.000webhostapp.com/getdata.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ReadJson(url_getdata);
        anhxa();
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=edtUsername.getText().toString();
                String pass=edtPassword.getText().toString();
                String email="";
                int i=0;
                int check=0;
                int size=arrayUser.size();
                for(i=0;i<size;i++)
                {
                    if(arrayUser.get(i).getUserName().equals(user) && arrayUser.get(i).getPassword().equals(pass))
                    {
                        Toast.makeText(SigninActivity.this, "dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                        check=1;
                        email=arrayUser.get(i).getEmail().toString();
                        break;
                    }
                }
                if(check==0) Toast.makeText(SigninActivity.this, "TÀI KHOẢN KHÔNG TỒN TẠI", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent intent1=new Intent(SigninActivity.this,MaincreenActivity.class);
                    //intent1.putExtra("username",user);
                    //intent1.putExtra("email",email);
                    edtUsername.setText("");
                    edtPassword.setText("");
                    startActivity(intent1);
                    //finish();
                }
            }
        });
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this,SignupActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putCharSequenceArrayList("User", (ArrayList) arrayUser);
//                intent.putExtra("BUNDLE",bundle);
                //finish();
                startActivity(intent);
                //finish();
            }
        });

        tvHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
    private void anhxa()
    {
        //arrayUser       = new ArrayList<>();
        btnSignin       =   (Button) findViewById(R.id.btnSignin);
        edtUsername     =   (EditText) findViewById(R.id.edtUsername);
        edtPassword     =   (EditText) findViewById(R.id.edtPassword);
        tvSignup        =   (TextView) findViewById(R.id.tvSignup);
        tvHaveAccount   =   (TextView) findViewById(R.id.tvhaveAcount);
    }
    public void ReadJson(String url)
    {
        RequestQueue requestqueue=Volley.newRequestQueue(SigninActivity.this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0;i<response.length();i++)
                        {
                            try {
                                JSONObject object =response.getJSONObject(i);
                                arrayUser.add(new User(
                                        object.getInt("Id"),
                                        object.getString("UserName"),
                                        object.getString("Email"),
                                        object.getString("Password"),
                                        object.getString("Phone")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SigninActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestqueue.add(jsonArrayRequest);
    }
}
