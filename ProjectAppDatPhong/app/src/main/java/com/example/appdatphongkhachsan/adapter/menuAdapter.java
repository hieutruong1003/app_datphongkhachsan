package com.example.appdatphongkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdatphongkhachsan.R;
import com.example.appdatphongkhachsan.model.menuapp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class menuAdapter extends BaseAdapter {

    ArrayList<menuapp> arrayMenuApp;
    Context context;

    public menuAdapter(ArrayList<menuapp> arrayMenuApp, Context applicationContext) {
        this.arrayMenuApp = arrayMenuApp;
        this.context = applicationContext;
    }

    public class  ViewHolder{
        TextView txtMenu;
        ImageView imgIconMenu;
    }

    @Override
    public int getCount() {
        return arrayMenuApp.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayMenuApp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.menu_app,null);
            viewHolder.txtMenu = (TextView) view.findViewById(R.id.txtMenu);
            viewHolder.imgIconMenu = (ImageView) view.findViewById(R.id.imageIconMenuApp);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        menuapp menuapp =(menuapp) getItem(i);
        viewHolder.txtMenu.setText(menuapp.getTitle());
        if(i==5){
            Picasso.with(context).load(R.drawable.img)
                    .placeholder(R.drawable.noimage)
                    .error(R.drawable.error)
                    .into(viewHolder.imgIconMenu);
        }else {
            Picasso.with(context).load(menuapp.getImg())
                    .placeholder(R.drawable.noimage)
                    .error(R.drawable.error)
                    .into(viewHolder.imgIconMenu);
        }
        return view;
    }
}
