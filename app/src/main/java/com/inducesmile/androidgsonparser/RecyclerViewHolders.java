package com.inducesmile.androidgsonparser;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;


public class RecyclerViewHolders extends RecyclerView.ViewHolder{

    public NetworkImageView carImage;
    public TextView carName;
    public TextView carPrice;

    public RecyclerViewHolders(View itemView) {
        super(itemView);

        carImage = (NetworkImageView) itemView.findViewById(R.id.imageView);
        carName = (TextView)itemView.findViewById(R.id.car_name);
        carPrice = (TextView)itemView.findViewById(R.id.car_price);
    }


}
