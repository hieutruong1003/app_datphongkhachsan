package com.example.appdatphongkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdatphongkhachsan.R;
import com.example.appdatphongkhachsan.activity.chitietDatPhong;
import com.example.appdatphongkhachsan.model.khachsan;
import com.example.appdatphongkhachsan.ultil.checkConnectInternet;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class khachsanAdapter extends RecyclerView.Adapter<khachsanAdapter.ItemHolder> {
    Context context;
    ArrayList<khachsan> arrayKhachSan;


    public khachsanAdapter(Context context, ArrayList<khachsan> arrayKhachSan) {
        this.context = context;
        this.arrayKhachSan = arrayKhachSan;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trangchinh_khachsan,null);
        v.setPadding(5,5,5,5);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        khachsan khachsan = arrayKhachSan.get(position);
        holder.txtTenKhachSan.setText(khachsan.getTenks());
        //holder.txtDiaChi.setText("Địa chỉ: "+khachsan.getDiachi());
        Picasso.with(context).load(khachsan.getHinhanh())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(holder.imgKhachSan);
    }
    @Override
    public int getItemCount() {
        return arrayKhachSan.size();
    }
    public class ItemHolder extends RecyclerView.ViewHolder{
        private ImageView imgKhachSan;
        private TextView txtTenKhachSan;
        public ItemHolder(View itemView){
            super(itemView);
            imgKhachSan = (ImageView) itemView.findViewById(R.id.imageViewKhachSan);
            txtTenKhachSan = (TextView) itemView.findViewById(R.id.textViewTenKS);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent  it = new Intent(context, chitietDatPhong.class);
                    it.putExtra("thongtinkhachsan",arrayKhachSan.get(getAdapterPosition()));
                    it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(it);
                }
            });
        }
    }
}
