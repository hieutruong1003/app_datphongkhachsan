package com.example.appdatphongkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdatphongkhachsan.R;
import com.example.appdatphongkhachsan.activity.chitietDatPhong;
import com.example.appdatphongkhachsan.model.khachsan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DatPhongAdapter extends BaseAdapter implements Filterable {
    ArrayList<khachsan> arrayKhachSan;
    ArrayList<khachsan> arraySearchKhachSan;
    Context context;
    ValueFilter valueFilter;
    public DatPhongAdapter( Context context,ArrayList<khachsan> arrayKhachSan) {
        this.arrayKhachSan = arrayKhachSan;
        this.arraySearchKhachSan = arrayKhachSan;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayKhachSan.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayKhachSan.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    public class ViewHolder{
        public TextView txtKhachSan,txtMota, txtGia,txtSdt,txtEmail,txtDiaChi;
        public ImageView imageViewDatPhong;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.datphong_adapter, null);
            viewHolder.imageViewDatPhong = (ImageView) convertView.findViewById(R.id.imageViewDatPhong);
            viewHolder.txtGia = (TextView) convertView.findViewById(R.id.textViewGiaKhachSan);
            viewHolder.txtSdt = (TextView) convertView.findViewById(R.id.textViewSdt);
            viewHolder.txtEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
            viewHolder.txtKhachSan = (TextView) convertView.findViewById(R.id.textViewKhachSan);
            viewHolder.txtDiaChi = (TextView) convertView.findViewById(R.id.textViewDiaChi);
            viewHolder.txtMota = (TextView) convertView.findViewById(R.id.textViewMoTa);
            convertView.setPadding(0,10,0,10);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        khachsan khachsan =(khachsan) getItem(position);
        viewHolder.txtGia.setText( khachsan.getGia()+".");
        viewHolder.txtMota.setMaxLines(3);
        viewHolder.txtMota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtMota.setText( khachsan.getMota());
        viewHolder.txtKhachSan.setText(khachsan.getTenks());
        viewHolder.txtSdt.setText(khachsan.getSdt());
        viewHolder.txtEmail.setText(khachsan.getEmail());
        viewHolder.txtDiaChi.setText(khachsan.getDiachi());
        Picasso.with(context).load(khachsan.getHinhanh())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imageViewDatPhong);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, chitietDatPhong.class);
                it.putExtra("thongtinkhachsan",arrayKhachSan.get(position));
                it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(it);
            }
        });
        return convertView;
    }
    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<khachsan> filterList = new ArrayList<khachsan>();
                for (int i = 0; i < arraySearchKhachSan.size(); i++) {
                    if ((arraySearchKhachSan.get(i).getTenks().toUpperCase())
                            .contains(constraint.toString().toUpperCase()) || (arraySearchKhachSan.get(i).getGia().toUpperCase())
                            .contains(constraint.toString().toUpperCase()) || (arraySearchKhachSan.get(i).getDiachi().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {

                        khachsan khachsan = new khachsan(arraySearchKhachSan.get(i)
                                .getMaks(), arraySearchKhachSan.get(i).getTenks(), arraySearchKhachSan.get(i).getGia(), arraySearchKhachSan.get(i).getSdt(),
                                arraySearchKhachSan.get(i).getEmail(), arraySearchKhachSan.get(i).getDiachi(), arraySearchKhachSan.get(i).getHinhanh(),
                                arraySearchKhachSan.get(i).getMota());
                        filterList.add(khachsan);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = arraySearchKhachSan.size();
                results.values = arraySearchKhachSan;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            arrayKhachSan = (ArrayList<khachsan>) results.values;
            notifyDataSetChanged();
        }
    }
    }
