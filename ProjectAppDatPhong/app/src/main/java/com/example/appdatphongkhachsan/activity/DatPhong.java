package com.example.appdatphongkhachsan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appdatphongkhachsan.R;
import com.example.appdatphongkhachsan.adapter.DatPhongAdapter;
import com.example.appdatphongkhachsan.model.khachsan;
import com.example.appdatphongkhachsan.ultil.Server;
import com.example.appdatphongkhachsan.ultil.checkConnectInternet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class DatPhong extends AppCompatActivity {
    EditText editTextTimKiem;
    TextView textViewTitleDatPhong;
    ImageButton btnsearchView,btnBack;
    Toolbar toolbarDatPhong;
    ListView listViewKhachSanDP;
    DatPhongAdapter datPhongAdapter;
    ArrayList<khachsan> arrayKhachSan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_phong);
        if(checkConnectInternet.haveNetworkConnection(getApplicationContext())){
            KhoiTaoDatPhong();
            getDataKhachSan();
            actionToolbar();
            setOnclickSearch();
        }else {
            checkConnectInternet.ShowToast(getApplicationContext(),"Kiểm tra lại kết nối của bạn!");
        }
    }

    private void setOnclickSearch() {
        btnsearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTitleDatPhong.setVisibility(View.GONE);
                editTextTimKiem.setVisibility(View.VISIBLE);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        editTextTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                datPhongAdapter.getFilter().filter(charSequence);
                datPhongAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void actionToolbar() {
        if(getSupportActionBar() != null) {
            setSupportActionBar(toolbarDatPhong);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("Đặt Phòng");
            toolbarDatPhong.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    private void getDataKhachSan() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongDanKhachSan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    String txtmaks = "", txttenks = "",txtGia="",txtSdt = "",txtEmail = "", txthinhanh = "", txtdiachi = "", txtmota = "";
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            txtmaks = jsonObject.getString("maks");
                            txttenks = jsonObject.getString("tenks");
                            txtGia =  jsonObject.getString("gia");
                            txtSdt = jsonObject.getString("sdt");
                            txtEmail =  jsonObject.getString("email");
                            txthinhanh = jsonObject.getString("hinhanh");
                            txtmota = jsonObject.getString("mota");
                            txtdiachi =jsonObject.getString("diachi");
                            arrayKhachSan.add(new khachsan(txtmaks, txttenks,txtGia,txtSdt,txtEmail, txtdiachi, txthinhanh, txtmota));
                            datPhongAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                checkConnectInternet.ShowToast(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void KhoiTaoDatPhong() {
        toolbarDatPhong =(Toolbar) findViewById(R.id.toolbarDatPhong);
        listViewKhachSanDP =(ListView) findViewById(R.id.listViewDatPhong);
        textViewTitleDatPhong = (TextView)findViewById(R.id.textTitleDatPhong);

        btnsearchView = (ImageButton) findViewById(R.id.buttonTimKiem);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        editTextTimKiem = (EditText) findViewById(R.id.EditTexTimKiem);
        arrayKhachSan = new ArrayList<>();
        datPhongAdapter = new DatPhongAdapter(getApplicationContext(), arrayKhachSan);
        listViewKhachSanDP.setAdapter(datPhongAdapter);

    }
}