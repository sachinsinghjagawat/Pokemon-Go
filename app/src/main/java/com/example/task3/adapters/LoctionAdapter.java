package com.example.task3.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task3.R;
import com.example.task3.adapterBhaibandhu.ItemsItem;
import com.example.task3.adapterBhaibandhu.LocationItem;
import com.example.task3.fragments.LocationFragment;

import java.util.ArrayList;
import java.util.List;

public class LoctionAdapter extends RecyclerView.Adapter<LoctionAdapter.ViewHolder> implements Filterable {

    private LocationFragment context;
    private List<LocationItem> liList;
    private List<LocationItem> liListFull;
    int count = 0;


    public LoctionAdapter(LocationFragment context, List<LocationItem> liList) {
        this.context = context;
        this.liList = liList;
//        liListFull = new ArrayList<>(liList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location , parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LocationItem li = liList.get(position);
        holder.location.setText(li.getLocation());
        holder.region.setText(li.getRegion());
        holder.area.setText(li.getAreas());

        boolean isShown = li.isExpanded();
        holder.show.setVisibility(isShown ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return liList.size();
    }

    @Override
    public Filter getFilter() {
        return listFilter;
    }

    private Filter listFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            count++ ;
            if (count == 1) {
                liListFull = new ArrayList<>(liList);
            }

            List<LocationItem> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(liList);
            }else{
                String filterPattern  = constraint.toString().toLowerCase().trim();
                for (LocationItem item : liListFull){
                    if(item.getLocation().toLowerCase().contains(constraint)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            liList.clear();
            liList.addAll((List) results.values);

            notifyDataSetChanged();
        }
    };


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView location;
        TextView region;
        TextView area;
        LinearLayout show ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            location = (TextView) itemView.findViewById(R.id.textView37);
            region = (TextView) itemView.findViewById(R.id.textView39);
            area = (TextView) itemView.findViewById(R.id.textView41);
            show = (LinearLayout) itemView.findViewById(R.id.expandableLinearLayoutLocation);
            LinearLayout clickShow = (LinearLayout)itemView.findViewById(R.id.clickShowLocation);

            clickShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LocationItem listItem = liList.get(getAdapterPosition());
                    listItem.setExpanded( !listItem.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                    Log.i("Region position" , String.valueOf(getAdapterPosition()));

                }
            });

        }
    }
}
