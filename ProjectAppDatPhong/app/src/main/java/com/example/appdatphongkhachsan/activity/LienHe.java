package com.example.appdatphongkhachsan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.appdatphongkhachsan.R;

import java.text.DecimalFormat;

public class LienHe extends AppCompatActivity {
    ImageView imageViewSdt,imageViewEmail;
    EditText editTextEmail,editTextSdt;
    Toolbar toolbarLienHe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lienhe);

        toolbarLienHe  = (Toolbar) findViewById(R.id.toolbarLienHe);
        editTextEmail = findViewById(R.id.editTextEmailLH);
        editTextSdt = findViewById(R.id.editTextSDTLH);

        imageViewEmail = findViewById(R.id.imageViewEmail);
        imageViewSdt = findViewById(R.id.imageViewSdt);

        ActionBar();

        imageViewEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                //it.setData(Uri.parse("mailto:"+editTextEmail.getText().toString())); // only email apps should handle this
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{editTextEmail.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT, "Đặt Phòng Khách Sạn by @ DAU");
                it.putExtra(Intent.EXTRA_TEXT, "Nhập nội dung mà bạn muốn gửi:");
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });
        imageViewSdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:"+editTextSdt.getText().toString()));
                startActivity(it);
            }
        });
        editTextSdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:"+editTextSdt.getText().toString()));
                startActivity(it);
            }
        });
        editTextEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                //it.setData(Uri.parse("mailto:"+editTextEmail.getText().toString())); // only email apps should handle this
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{editTextEmail.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT, "Đặt Phòng Khách Sạn by @ DAU");
                it.putExtra(Intent.EXTRA_TEXT, "Nhập nội dung mà bạn muốn gửi:");
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });
    }

    private void ActionBar() {
        setSupportActionBar(toolbarLienHe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarLienHe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}