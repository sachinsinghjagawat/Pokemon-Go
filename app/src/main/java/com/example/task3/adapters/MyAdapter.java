package com.example.task3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task3.adapterBhaibandhu.ItemsItem;
import com.example.task3.adapterBhaibandhu.ListItem;
import com.example.task3.R;
import com.example.task3.dataCollection.Pokemon;
import com.example.task3.fragments.PokemonFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements Filterable {

    private Context context1;
    private List<ListItem> listItemList;
    private List<ListItem> listItemListFull;
    int count = 0;


    private PokemonFragment context;

    public MyAdapter(List<ListItem> listItemList, PokemonFragment context) {
        this.listItemList = listItemList;
        this.context = context;
//        listItemListFull = new ArrayList<>(listItemList);
    }
    public MyAdapter(List<ListItem> listItemList, Context context) {
        this.listItemList = listItemList;
        this.context1 = context;
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
        holder.moves.setText(listItem.getMove());
        holder.statistics.setText(listItem.getStatistics());
        holder.types.setText(listItem.getTypes());
        Picasso.get().load(listItem.getImageUrl()).fit().centerCrop().into(holder.image);

        boolean isExpanded = listItem.isExpandable();
        holder.expandableView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return listItemList.size();
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
                listItemListFull = new ArrayList<>(listItemList);
            }

            List<ListItem> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(listItemListFull);
            }else{
                String filterPattern  = constraint.toString().toLowerCase().trim();
                for (ListItem item : listItemListFull){
                    if(item.getHeading().toLowerCase().contains(constraint)){
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
            listItemList.clear();
            listItemList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView headingText;
        public TextView descriptionText;
        public ImageView image;
        public TextView moves;
        public TextView statistics;
        public TextView types;
        public LinearLayout expandableView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            headingText = (TextView) itemView.findViewById(R.id.headingTextView);
            descriptionText = (TextView) itemView.findViewById(R.id.textView2);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            moves = (TextView) itemView.findViewById(R.id.textView6);
            statistics = (TextView) itemView.findViewById(R.id.textView8);
            types = (TextView) itemView.findViewById(R.id.textView10);
            LinearLayout showView = (LinearLayout) itemView.findViewById(R.id.showView);
            expandableView = (LinearLayout) itemView.findViewById(R.id.expandableView);

            showView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ListItem listItem = listItemList.get(getAdapterPosition());
                    listItem.setExpandable( !listItem.isExpandable());
                    notifyItemChanged(getAdapterPosition());

                }
            });


        }
    }
}
