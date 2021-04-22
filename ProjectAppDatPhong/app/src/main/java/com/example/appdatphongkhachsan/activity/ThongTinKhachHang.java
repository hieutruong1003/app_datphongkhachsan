package com.example.appdatphongkhachsan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AuthenticationRequiredException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appdatphongkhachsan.R;
import com.example.appdatphongkhachsan.ultil.Server;
import com.example.appdatphongkhachsan.ultil.checkConnectInternet;

import java.util.HashMap;
import java.util.Map;

public class ThongTinKhachHang extends AppCompatActivity {
    Toolbar toolbarKhachHang;
    EditText editTextHoTen,editTextEmail,editTextSdt,editTextDiaChi,editTextCmnd;
    RadioGroup radioGroupGioiTinh;
    RadioButton radioButtonNam,radioButtonNu;
    Button btnHuy,btnXacNhan;
    String maks,vitriphong,loaiphong,soluong,ngayden,ngaydi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin_khachhang);
        KhoiTao();
        ActionBar();
        ButonOnClick();
        getDuLieu();
    }
    public void writeSharePrefs(String hoten, String cmnd, String sdt,String gioitinh,String email,String diachi ){
        SharedPreferences preferences = getSharedPreferences("thongtinkhachhang",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("hovaten",hoten);
        editor.putString("cmnd",cmnd);
        editor.putString("sdt",sdt);
        editor.putString("gioitinh",gioitinh);
        editor.putString("email",email);
        editor.putString("diachi",diachi);
        editor.commit();
    }
    public void readSharePrefs(){
        SharedPreferences preferences = getSharedPreferences("thongtinkhachhang",MODE_PRIVATE);
        editTextHoTen.setText(preferences.getString("hovaten",""));
        editTextSdt.setText(preferences.getString("sdt",""));
        editTextEmail.setText(preferences.getString("email",""));
        editTextDiaChi.setText(preferences.getString("diachi",""));
        editTextCmnd.setText(preferences.getString("cmnd",""));
        if (preferences.getString("gioitinh", "").equals(0)) {
            radioButtonNu.setChecked(true);
        }else {
            radioButtonNam.setChecked(true);
        }
    }
    private void getDuLieu() {
        Intent it = getIntent();
        maks = it.getStringExtra("maks");
        vitriphong = it.getStringExtra("vitriphong");
        loaiphong = it.getStringExtra("loaiphong");
        soluong = it.getStringExtra("soluong");
        ngayden = it.getStringExtra("ngayden");
        ngaydi = it.getStringExtra("ngaydi");
    }

    private void ButonOnClick() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = getIntent();
                final String tenkh = editTextHoTen.getText().toString();
                final String cmnd = editTextCmnd.getText().toString().trim();
                String check = "";
                if (radioButtonNam.isChecked()) {
                    check = "1";
                } else {
                    check = "0";
                }
                final String gioitinh = check;
                final String sdt = editTextSdt.getText().toString().trim();
                final String email = editTextEmail.getText().toString().trim();
                final String diachi = editTextDiaChi.getText().toString().trim();
                writeSharePrefs(tenkh,cmnd,sdt,gioitinh,email,diachi);
                if (tenkh.length() > 0 && cmnd.length() > 0 && gioitinh.length() > 0 && sdt.length() > 0 && email.length() > 0 && diachi.length() > 0) {
                    final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.DuongDanInsertKhachHang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String makh) {
                            Log.d("makh",makh);
                            if( makh.length() > 0){
                                RequestQueue requestQueue1 = Volley.newRequestQueue(getApplicationContext());
                                StringRequest stringRequest1 = new StringRequest(Request.Method.POST, Server.DuongDanDatPhong, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                            if(response.equals("1")){
                                                checkConnectInternet.ShowToast(getApplicationContext(),"Đặt Phòng thành công!!!");
                                                Intent it = new Intent(ThongTinKhachHang.this,MainActivity.class);
                                                startActivity(it);
                                                checkConnectInternet.ShowToast(getApplicationContext(),"Cám ơn bạn đã đặt phòng, bạn có thể đặt thêm phòng nếu cần");
                                            }else {
                                                checkConnectInternet.ShowToast(getApplicationContext(),"Hệ thống bị lỗi chức năng Đặt Phòng!!! Xin Lỗi vì sự bất tiện này");
                                            }
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                }){
                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {
                                        Map<String,String> hashMap = new HashMap<String,String>();
                                        hashMap.put("maks",maks);
                                        hashMap.put("vitriphong",vitriphong);
                                        hashMap.put("loaiphong",loaiphong);
                                        hashMap.put("soluong",soluong);
                                        hashMap.put("ngayden",ngayden);
                                        hashMap.put("ngaydi",ngaydi);
                                        hashMap.put("makh",makh);
                                        return hashMap;
                                    }
                                };
                                requestQueue1.add(stringRequest1);
                            }else {
                                Toast.makeText(ThongTinKhachHang.this, "Không tìm thấy Mã Khách Hàng", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put("tenkh",tenkh);
                            hashMap.put("cmnd",cmnd);
                            hashMap.put("gioitinh", gioitinh);
                            hashMap.put("sdt",sdt);
                            hashMap.put("email",email);
                            hashMap.put("diachi",diachi);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                }else {
                    Toast.makeText(ThongTinKhachHang.this, "Thông tin bị thiếu!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void ActionBar() {
        setSupportActionBar(toolbarKhachHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarKhachHang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void KhoiTao() {
        toolbarKhachHang = findViewById(R.id.toolbarKhachHang);
        editTextCmnd = findViewById(R.id.editTextCMND);
        editTextDiaChi = findViewById(R.id.editTextDiaChi);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSdt = findViewById(R.id.editTextSDT);
        editTextHoTen = findViewById(R.id.editTextTenKH);

        btnHuy = findViewById(R.id.btnHuy);
        btnXacNhan = findViewById(R.id.btnXacNhan);
        radioGroupGioiTinh = findViewById(R.id.radioGroupGioiTinh);
        radioButtonNam = findViewById(R.id.radioNam);
        radioButtonNu = findViewById(R.id.radioNu);
        readSharePrefs();
    }
}