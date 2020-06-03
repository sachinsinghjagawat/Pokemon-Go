package com.example.task3;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItemList;
    private Context context;

    public MyAdapter(List<ListItem> listItemList, Context context) {
        this.listItemList = listItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items , parent , false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ListItem listItem = listItemList.get(position);
        holder.headingText.setText(listItem.getHeading());
        holder.descriptionText.setText(listItem.getDescription());
        Picasso.get().load(listItem.getImageUrl()).fit().centerCrop().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView headingText;
        public TextView descriptionText;
        public ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            headingText = (TextView) itemView.findViewById(R.id.headingTextView);
            descriptionText = (TextView) itemView.findViewById(R.id.textView2);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
