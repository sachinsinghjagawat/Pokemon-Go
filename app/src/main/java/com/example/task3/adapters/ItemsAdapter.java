package com.example.task3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task3.R;
import com.example.task3.adapterBhaibandhu.ItemsItem;
import com.example.task3.adapterBhaibandhu.ListItem;
import com.example.task3.fragments.ItemsFragment;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private ItemsFragment context;
    private List<ItemsItem> iiList;

    public ItemsAdapter(ItemsFragment context, List<ItemsItem> iiList) {
        this.context = context;
        this.iiList = iiList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_items , parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemsItem ii = iiList.get(position);
        holder.item.setText(ii.getItem());
        holder.flingPower.setText(ii.getFlingPower());
        holder.category.setText(ii.getCategory());
        holder.heldByPokemon.setText(ii.getHeldByPokemon());
        holder.effectEntries.setText(ii.getEffectEntries());

        boolean isShown = ii.isExpanded();
        holder.show.setVisibility(isShown ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return iiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        TextView flingPower;
        TextView category;
        TextView heldByPokemon;
        TextView effectEntries;
        LinearLayout show ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item = (TextView) itemView.findViewById(R.id.textView24);
            flingPower = (TextView) itemView.findViewById(R.id.textView25);
            category = (TextView) itemView.findViewById(R.id.textView27);
            heldByPokemon = (TextView) itemView.findViewById(R.id.textView29);
            effectEntries = (TextView) itemView.findViewById(R.id.textView31);
            show = (LinearLayout) itemView.findViewById(R.id.expandableLinearLayoutItems);
            LinearLayout clickShow = (LinearLayout)itemView.findViewById(R.id.clickShowItem);

            clickShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ItemsItem listItem = iiList.get(getAdapterPosition());
                    listItem.setExpanded( !listItem.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
