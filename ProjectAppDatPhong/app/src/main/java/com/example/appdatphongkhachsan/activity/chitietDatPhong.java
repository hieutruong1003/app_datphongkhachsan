
package com.example.appdatphongkhachsan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appdatphongkhachsan.R;
import com.example.appdatphongkhachsan.model.khachsan;
import com.example.appdatphongkhachsan.model.phong;
import com.example.appdatphongkhachsan.ultil.Server;
import com.example.appdatphongkhachsan.ultil.checkConnectInternet;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class chitietDatPhong extends AppCompatActivity {
    Toolbar toolbarDatPhong;
    Button buttonDatphong;
    ImageButton imageButtonPre,imageButtonNext;
    EditText editTextNgayDen,editTextNgayDi;
    Button btnCong,btnTru,btnSoLuong;
    Spinner spinnerLoaiPhong, spinnerViTriPhong;
    TextView textViewGia,textViewDiaChi,textViewSdt,textViewMota,textViewEmail,textViewTenKhachSan,textViewTongTien;
    ImageView imageViewDatPhong;
    ArrayList<Integer> arrayLoaiPhong,arrayViTriPhong,arrayListImage;
    ArrayList<String> arrayListLoaiPhong;
    ArrayList<String> arrayListViTriPhong;
    ArrayAdapter<String> arrayAdapterLoaiPhong,arrayAdapterViTriPhong;
    ArrayList<phong> arrayListPhong;
    String maks,tenks,sdt, mota, diachi, hinhanh, email;
    String ngaydi,ngayden;
    int loaiphong,image = 0;
    int giaphong;
    int vitriphong;
    int soluong = 1;
    Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_datphong);
        KhoiTao();
        ActionToolbar();
        getLoaiPhong();
        getViTriPhong();
        getDanhSachPhong();
        getDuLieuKhachSan();
        spinnerOnItemClick();
        OnClickButtonSoLuong();
        DatePickerNgayDi();
        DatePickerNgayDen();
        imageButtonOnClick();
        ButtonClick();
    }

    private void ButtonClick() {
        buttonDatphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngaydi = editTextNgayDi.getText().toString();
                ngayden =editTextNgayDen.getText().toString();
                if(maks.length() > 0 && soluong > 0 && vitriphong > 0 && loaiphong > 0){
                Intent it = new Intent(chitietDatPhong.this, ThongTinKhachHang.class);
                it.putExtra("maks",maks);
                it.putExtra("soluong",String.valueOf(soluong));
                it.putExtra("vitriphong",String.valueOf(vitriphong));
                it.putExtra("loaiphong",String.valueOf(loaiphong));
                it.putExtra("ngaydi",ngaydi);
                it.putExtra("ngayden",ngayden);
                startActivity(it);
                }else {
                    checkConnectInternet.ShowToast(getApplicationContext(),"Lỗi Khi đặt phòng!!!");
                }

            }
        });
    }

    private void imageButtonOnClick() {
        arrayListImage.add(0);
        arrayListImage.add(R.drawable.slidera);
        arrayListImage.add(R.drawable.sliderb);
        arrayListImage.add(R.drawable.sliderc);
        arrayListImage.add(R.drawable.sliderd);
        arrayListImage.add(R.drawable.slidere);
        imageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image++;
                if(image == 0){
                    Picasso.with(getApplicationContext()).load(hinhanh)
                            .placeholder(R.drawable.noimage)
                            .error(R.drawable.error)
                            .into(imageViewDatPhong);
                }else if(image == arrayListImage.size()) {
                    Picasso.with(getApplicationContext()).load(hinhanh)
                            .placeholder(R.drawable.noimage)
                            .error(R.drawable.error)
                            .into(imageViewDatPhong);
                    image = 0;
                }else {
                    imageViewDatPhong.setImageResource(arrayListImage.get(image));
                }

            }
        });

        imageButtonPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image--;
                if(image < 0){
                    image = arrayListImage.size() - 1;
                    imageViewDatPhong.setImageResource(arrayListImage.get(image));
                }else if(image == 0) {
                    Picasso.with(getApplicationContext()).load(hinhanh)
                            .placeholder(R.drawable.noimage)
                            .error(R.drawable.error)
                            .into(imageViewDatPhong);
                }else {
                    imageViewDatPhong.setImageResource(arrayListImage.get(image));
                }
            }
        });
    }

    private void setGiaPhong() {
        vitriphong = arrayViTriPhong.get((int) spinnerViTriPhong.getSelectedItemId());
        loaiphong = arrayLoaiPhong.get((int) spinnerLoaiPhong.getSelectedItemId());
        for (phong p: arrayListPhong) {
            if(p.getMaks().equalsIgnoreCase(maks)==true && p.getLoaiphong().equalsIgnoreCase(String.valueOf(loaiphong))==true
                    && p.getVitriphong().equalsIgnoreCase(String.valueOf(vitriphong))==true && p.getTrangthai().equalsIgnoreCase("0")==true){
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                textViewGia.setText(""+decimalFormat.format(Integer.parseInt(p.getGiaphong()))+" VNĐ/Phòng");
                giaphong = Integer.parseInt(p.getGiaphong());
                break;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaydi = null;
        Date ngayden = null;
        try {
            ngaydi = sdf.parse(editTextNgayDi.getText().toString());
            ngayden = sdf.parse(editTextNgayDen.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int songay = DaysBetWeen(ngaydi,ngayden);
        soluong = Integer.parseInt(btnSoLuong.getText().toString());
        int tongtien = 0;
        if(songay == 0){
            tongtien = soluong*giaphong;
        }else if(songay>0){
            tongtien = songay*giaphong*soluong;
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        textViewTongTien.setText(""+decimalFormat.format(tongtien)+" VNĐ");
    }
    public int DaysBetWeen(Date d1,Date d2){
        return (int) (d1.getTime() - d2.getTime())/(1000*60*60*24);
    }
    private void DatePickerNgayDi() {
        myCalendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Date dateHienTai= new Date();
        myCalendar.roll(Calendar.DATE,1);
        dateHienTai = myCalendar.getTime();
        editTextNgayDi.setText(sdf.format(dateHienTai));
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(editTextNgayDi);
                setGiaPhong();
            }
        };

        editTextNgayDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(chitietDatPhong.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void DatePickerNgayDen(){
        myCalendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Date dateHienTai= new Date();
        dateHienTai = myCalendar.getTime();
        editTextNgayDen.setText(sdf.format(dateHienTai));
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(editTextNgayDen);
                setGiaPhong();
            }
        };
        editTextNgayDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(chitietDatPhong.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void updateLabel(EditText editText) {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(sdf.format(myCalendar.getTime()));
    }
    private void OnClickButtonSoLuong() {

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soluong--;
                if(soluong == 0){
                    soluong = 1;
                }
                btnSoLuong.setText(String.valueOf(soluong));
                setGiaPhong();
            }
        });
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soluong++;
                int maxPhong = 0;
                for (phong p:arrayListPhong) {
                    if(p.getMaks().equalsIgnoreCase(maks)==true && p.getLoaiphong().equalsIgnoreCase(String.valueOf(loaiphong))==true
                            && p.getVitriphong().equalsIgnoreCase(String.valueOf(vitriphong))==true &&  p.getTrangthai().equalsIgnoreCase("0")==true){
                        maxPhong++;
                    }
                }
                if (soluong > maxPhong) {
                    Toast.makeText(chitietDatPhong.this, "Số phòng còn trống: "+maxPhong, Toast.LENGTH_SHORT).show();
                    soluong = maxPhong;
                }
                if(soluong == 11){
                    soluong = 10;
                }
                btnSoLuong.setText(String.valueOf(soluong));
                setGiaPhong();
            }
        });
    }

    private void spinnerOnItemClick() {
        spinnerLoaiPhong.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setGiaPhong();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerViTriPhong.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setGiaPhong();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getDanhSachPhong() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongDanPhong, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    String maphong = "", maks = "";
                    String giaphong="",vitriphong="",loaiphong="";
                    String  trangthai="";
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            maphong = jsonObject.getString("maphong");
                            maks = jsonObject.getString("maks");
                            giaphong = jsonObject.getString("giaphong");
                            vitriphong =jsonObject.getString("vitriphong");
                            trangthai = jsonObject.getString("trangthai");
                            loaiphong = jsonObject.getString("loaiphong");
                            arrayListPhong.add(new phong(maphong,maks,loaiphong,vitriphong,giaphong,trangthai));
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

    private void ActionToolbar() {
        setSupportActionBar(toolbarDatPhong);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarDatPhong.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getDuLieuKhachSan() {
        khachsan khachsan1 = (khachsan) getIntent().getSerializableExtra("thongtinkhachsan");
        maks = khachsan1.getMaks();
        tenks = khachsan1.getTenks();
        sdt = khachsan1.getSdt();
        mota = khachsan1.getMota();
        diachi = khachsan1.getDiachi();
        hinhanh = khachsan1.getHinhanh();
        email = khachsan1.getEmail();
        toolbarDatPhong.setTitle(tenks);
        textViewTenKhachSan.setText(tenks);
        textViewMota.setText("" + mota);
        textViewSdt.setText("Sdt: " + sdt);
        textViewEmail.setText("Email: "+ email);
        textViewDiaChi.setText("Địa chỉ: "+ diachi);
        Picasso.with(getApplicationContext()).load(hinhanh)
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(imageViewDatPhong);
    }

    private void getViTriPhong() {
        /* Lấy dữ liệu tất cả Vị Trí Phòng Đang có  lên sipner*/
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongDanViTriPhong, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            arrayListViTriPhong.add("Tầng "+ response.getString(i));
                            arrayViTriPhong.add(response.getInt(i));
                            arrayAdapterViTriPhong.notifyDataSetChanged();
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

    private void getLoaiPhong() {
        /* Lấy dữ liệu tất cả Loại Phòng Đang có  lên sipner*/
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongDanLoaiPhong, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            arrayListLoaiPhong.add(response.get(i).toString() +" người");
                            arrayLoaiPhong.add(response.getInt(i));
                            arrayAdapterLoaiPhong.notifyDataSetChanged();
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

    private void KhoiTao() {
        toolbarDatPhong =(Toolbar) findViewById(R.id.toolbarDatPhong);
        buttonDatphong = (Button) findViewById(R.id.btnDatPhong);
        editTextNgayDen = (EditText) findViewById(R.id.editTextNgayDen);
        editTextNgayDi = findViewById(R.id.editTextNgayDi);
        spinnerLoaiPhong = findViewById(R.id.spinnerLoaiPhong);
        spinnerViTriPhong = findViewById(R.id.spinnerViTri);

        textViewDiaChi = findViewById(R.id.textViewDiaChi);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewGia = findViewById(R.id.textViewGiaPhong);
        textViewSdt = findViewById(R.id.textViewSdt);
        textViewTenKhachSan = findViewById(R.id.textViewKhachSanDatPhong);
        textViewMota = findViewById(R.id.textViewMoTa);
        textViewTongTien = findViewById(R.id.textViewTongTien);

        imageViewDatPhong = findViewById(R.id.imageViewDatPhong);
        imageButtonPre = findViewById(R.id.imageButonBack);
        imageButtonNext = findViewById(R.id.imageButtonNext);

        btnCong = findViewById(R.id.buttonCongSoLuong);
        btnSoLuong = findViewById(R.id.buttonSoLuong);
        btnTru = findViewById(R.id.buttonTruSoLuong);

        arrayListLoaiPhong = new ArrayList<>();
        arrayListViTriPhong = new ArrayList<>();
        arrayListPhong = new ArrayList<>();
        arrayLoaiPhong = new ArrayList<>();
        arrayViTriPhong = new ArrayList<>();
        arrayListImage = new ArrayList<>();


        arrayAdapterLoaiPhong = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayListLoaiPhong);
        arrayAdapterViTriPhong = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayListViTriPhong);
        spinnerLoaiPhong.setAdapter(arrayAdapterLoaiPhong);
        spinnerViTriPhong.setAdapter(arrayAdapterViTriPhong);

    }
}