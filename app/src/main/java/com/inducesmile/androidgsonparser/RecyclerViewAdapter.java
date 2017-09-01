package com.inducesmile.androidgsonparser;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders>  implements View.OnClickListener{

    private List<ItemObject> itemList;
    private Context context;
    private ImageLoader imageLoader;


    public interface PositionOfCar {

        void sendPosition(int position);
    }
    PositionOfCar positionOfCar;
    public RecyclerViewAdapter(Context context, List<ItemObject> itemList,ImageLoader imageLoader) {
        this.itemList = itemList;
        this.context = context;
        this.imageLoader=imageLoader;
        positionOfCar=(PositionOfCar) context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);

        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        layoutView.setOnClickListener(this);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        String imageUrl="https://prod.drive-now-content.com/fileadmin/user_upload_global/assets/cars/"+itemList.get(position).getModelIdentifier()+""+"/"+itemList.get(position).getColor()+""+"/2x/car.png";
        holder.carImage.setImageUrl(imageUrl,imageLoader);
        holder.carName.setText("" + itemList.get(position).getId());
        holder.carPrice.setText("" + itemList.get(position).getSeries());
        positionOfCar.sendPosition(position);

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context,MapActivity.class );

        context.startActivity(intent);

    }
}
