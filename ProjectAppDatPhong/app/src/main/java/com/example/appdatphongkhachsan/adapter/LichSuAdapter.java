package com.example.appdatphongkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdatphongkhachsan.R;
import com.example.appdatphongkhachsan.model.LichSu;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.Inflater;

public class LichSuAdapter extends BaseAdapter {
    ArrayList<LichSu> arrayListLichSu;
    Context context;

    public LichSuAdapter(ArrayList<LichSu> arrayListLichSu, Context context) {
        this.arrayListLichSu = arrayListLichSu;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListLichSu.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListLichSu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }public class ViewHolder{
        public TextView textViewKhachSanLichSu,textViewViTriPhongLichSu,textViewLoaiPhongLichSu,textViewTongTienLichSu,
                textViewNgayDenLichSu,textViewNgayDiLichSu,textViewSoLuong,textViewTongTien;
        public Button buttonHuyDatHang;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lichsu_adapter,null);
            viewHolder.textViewKhachSanLichSu = convertView.findViewById(R.id.textViewKhachSanLichSu);
            viewHolder.textViewLoaiPhongLichSu = convertView.findViewById(R.id.textViewLoaiPhongLichSu);
            viewHolder.textViewViTriPhongLichSu = convertView.findViewById(R.id.textViewViTriPhongLichSu);
            viewHolder.textViewTongTienLichSu = convertView.findViewById(R.id.textViewTongTienLichSu);
            viewHolder.textViewNgayDiLichSu = convertView.findViewById(R.id.textViewNgayDiLichSu);
            viewHolder.textViewNgayDenLichSu = convertView.findViewById(R.id.textViewNgayDenLichSu);
            viewHolder.textViewTongTien = convertView.findViewById(R.id.textViewTongTienLichSu);
            convertView.setPadding(10,10,10,10);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        LichSu lichSu = (LichSu) getItem(position);
        viewHolder.textViewKhachSanLichSu.setText(lichSu.getTenks());
        viewHolder.textViewViTriPhongLichSu.setText("Vị Trí Phòng: Tầng "+lichSu.getVitriphong());
        viewHolder.textViewLoaiPhongLichSu.setText("Loại Phòng: "+lichSu.getLoaiphong()+" người");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = null,d2= null;
        try {
            d1 = sdf.parse(lichSu.getNgayden());
            d2 = sdf.parse(lichSu.getNgaydi());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        viewHolder.textViewNgayDiLichSu.setText("Ngày Đi: "+lichSu.getNgayden());
        viewHolder.textViewNgayDenLichSu.setText("Ngày Đến:"+lichSu.getNgaydi());
        long songay = ((d2.getTime() - d1.getTime())/(1000*60*60*24));
        if(songay < 0){
            songay = songay * (-1);
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.textViewTongTien.setText("Giá Phòng\\"+songay+" ngày: " +decimalFormat.format(songay*Integer.parseInt(lichSu.getGiaphong()))+" VND");
        return convertView;
    }
}
