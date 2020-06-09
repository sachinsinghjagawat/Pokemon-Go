package com.example.task3.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task3.R;
import com.example.task3.adapterBhaibandhu.ItemsItem;
import com.example.task3.adapterBhaibandhu.RegionItem;
import com.example.task3.fragments.RegionFragment;

import java.util.List;

public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.ViewHolder> {

    private RegionFragment context;
    private List<RegionItem> riList;

    public RegionAdapter(RegionFragment context, List<RegionItem> riList) {
        this.context = context;
        this.riList = riList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_region , parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RegionItem ri = riList.get(position);
        holder.region.setText(ri.getRegion());
        holder.location.setText(ri.getLocation());
        holder.pokedoxes.setText(ri.getPokedoes());

        boolean isShown = ri.isExpanded();
        holder.show.setVisibility(isShown ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return riList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView region;
        TextView location;
        TextView pokedoxes;
        LinearLayout show ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            region = (TextView) itemView.findViewById(R.id.textView32);
            location = (TextView) itemView.findViewById(R.id.textView34);
            pokedoxes = (TextView) itemView.findViewById(R.id.textView36);
            show = (LinearLayout) itemView.findViewById(R.id.expandableLinearLayoutRegion);
            LinearLayout clickShow = (LinearLayout)itemView.findViewById(R.id.clickShowRegion);


            clickShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    RegionItem listItem = riList.get(getAdapterPosition());
                    listItem.setExpanded( !listItem.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                    Log.i("Region position" , String.valueOf(getAdapterPosition()));


                }
            });


        }
    }
}
