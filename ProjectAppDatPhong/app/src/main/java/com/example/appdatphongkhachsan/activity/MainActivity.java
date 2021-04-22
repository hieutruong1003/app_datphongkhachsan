package com.example.appdatphongkhachsan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appdatphongkhachsan.R;
import com.example.appdatphongkhachsan.adapter.khachsanAdapter;
import com.example.appdatphongkhachsan.adapter.menuAdapter;
import com.example.appdatphongkhachsan.model.khachsan;
import com.example.appdatphongkhachsan.model.menuapp;
import com.example.appdatphongkhachsan.ultil.Server;
import com.example.appdatphongkhachsan.ultil.checkConnectInternet;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipperSlider;
    RecyclerView recyclerViewManHinhChinh;
    NavigationView navigationView;
    ListView listViewManHinhChinh;
    DrawerLayout drawerLayoutApp;
    TextView txtTitle;
    menuAdapter menuApp;
    ArrayList<menuapp> arrayMenuApp;
    ArrayList<khachsan> arrayKhachSan;
    khachsanAdapter khachSanAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KhoiTao();
        ActionToolBar();
        ActionViewFlipper();
        if(checkConnectInternet.haveNetworkConnection(getApplicationContext())){
            GetDuLieuKhachSan();
            onClcikItemListView();
        }else {
            checkConnectInternet.ShowToast(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối internet!!!");
        }
    }



    private void onClcikItemListView() {
        listViewManHinhChinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        if (checkConnectInternet.haveNetworkConnection(getApplicationContext())) {
                            Intent it = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(it);
                        } else {
                            checkConnectInternet.ShowToast(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!!!");
                        }
                        drawerLayoutApp.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case 1: {
                        Intent it = new Intent(MainActivity.this, DatPhong.class);
                        startActivity(it);
                        break;
                    }
                    case 2: {
                        if (checkConnectInternet.haveNetworkConnection(getApplicationContext())) {
                            Intent it = new Intent(MainActivity.this, LichSuDatPhong.class);
                            startActivity(it);
                        } else {
                            checkConnectInternet.ShowToast(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!!!");
                        }
                        drawerLayoutApp.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case 3: {
                        if (checkConnectInternet.haveNetworkConnection(getApplicationContext())) {
                            Intent it = new Intent(MainActivity.this,LienHe.class);
                            System.out.println("ok");
                            startActivity(it);

                        } else {
                            checkConnectInternet.ShowToast(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!!!");
                        }
                        drawerLayoutApp.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case 4: {
                        if (checkConnectInternet.haveNetworkConnection(getApplicationContext())) {
                            Intent it = new Intent(MainActivity.this, ThongTinApp.class);
                            startActivity(it);
                        } else {
                            checkConnectInternet.ShowToast(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!!!");
                        }
                        drawerLayoutApp.closeDrawer(GravityCompat.START);
                        break;
                    }
                }
            }
        });
        }

    private void GetDuLieuKhachSan() {
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
                            txtGia = jsonObject.getString("gia");
                            txtSdt = jsonObject.getString("sdt");
                            txtEmail = jsonObject.getString("email");
                            txthinhanh = jsonObject.getString("hinhanh");
                            txtmota = jsonObject.getString("mota");
                            txtdiachi = jsonObject.getString("diachi");
                            arrayKhachSan.add(new khachsan(txtmaks, txttenks,txtGia,txtSdt,txtEmail, txtdiachi, txthinhanh, txtmota));
                            khachSanAdapter.notifyDataSetChanged();
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

    private void ActionViewFlipper() {
        ArrayList<Integer> sliderApp = new ArrayList<>();
        sliderApp.add(R.drawable.slidera);
        sliderApp.add(R.drawable.sliderb);
        sliderApp.add(R.drawable.sliderc);
        sliderApp.add(R.drawable.sliderd);
        sliderApp.add(R.drawable.slidere);
        for(int i = 0 ; i < sliderApp.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(sliderApp.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipperSlider.addView(imageView);
        }
        viewFlipperSlider.setFlipInterval(5000);
        viewFlipperSlider.setAutoStart(true);
        Animation animation_slider_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slider_in_right);
        Animation animation_slider_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slider_out_right);
        viewFlipperSlider.setInAnimation(animation_slider_in);
        viewFlipperSlider.setOutAnimation(animation_slider_out);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayoutApp.openDrawer(GravityCompat.START);
            }
        });
    }

    private void KhoiTao() {
        toolbar =(Toolbar) findViewById(R.id.toolbarTrangChinh);
        viewFlipperSlider = (ViewFlipper) findViewById(R.id.viewflipperSlider);
        recyclerViewManHinhChinh = (RecyclerView) findViewById(R.id.recylerViewApp);
        navigationView = (NavigationView) findViewById(R.id.navigationViewManHinhChinh);
        listViewManHinhChinh  = (ListView) findViewById(R.id.listViewManHinhChinh);
        drawerLayoutApp = (DrawerLayout) findViewById(R.id.drawerLayoutApp);
        txtTitle = findViewById(R.id.txtTitle);

        arrayMenuApp = new ArrayList<>();
        menuapp menu1 = new menuapp("https://image.flaticon.com/icons/png/512/8/8811.png","Trang Chủ");
        menuapp menu2 = new menuapp("https://image.flaticon.com/icons/png/512/38/38363.png","Đặt Phòng");
        menuapp menu3 = new menuapp("https://image.flaticon.com/icons/png/512/61/61122.png","Lịch Sử");
        menuapp menu4 = new menuapp("https://image.freepik.com/free-icon/info-logo-circle_318-947.jpg","Thông Tin");
        menuapp menu5 = new menuapp("https://image.flaticon.com/icons/png/512/14/14628.png","Liên Hệ");
        menuapp menu6 = new menuapp("https://st.quantrimang.com/photos/image/2020/07/30/Hinh-Nen-Trang-10.jpg","");
        arrayMenuApp.add(menu1);
        arrayMenuApp.add(menu2);
        arrayMenuApp.add(menu3);
        arrayMenuApp.add(menu5);
        arrayMenuApp.add(menu4);
        arrayMenuApp.add(menu6);

        menuApp = new menuAdapter(arrayMenuApp, getApplicationContext());
        listViewManHinhChinh.setAdapter(menuApp);

        arrayKhachSan  = new ArrayList<>();
        khachSanAdapter = new khachsanAdapter(getApplicationContext(),arrayKhachSan);
        recyclerViewManHinhChinh.setHasFixedSize(true);
        recyclerViewManHinhChinh.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewManHinhChinh.setAdapter(khachSanAdapter);
    }
}