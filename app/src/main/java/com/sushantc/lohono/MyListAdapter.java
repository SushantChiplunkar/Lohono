package com.sushantc.lohono;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class MyListAdapter extends ListAdapter<CustomData,MyListAdapter.ViewHolder> {


    public MyListAdapter() {
        super(diffCallback);
    }

    private static DiffUtil.ItemCallback<CustomData> diffCallback = new DiffUtil.ItemCallback<CustomData>() {
        @Override
        public boolean areItemsTheSame(@NonNull CustomData oldItem, @NonNull CustomData newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CustomData oldItem, @NonNull CustomData newItem) {
            return false;
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(getItem(position).getTitle());
        holder.desc.setText(getItem(position).getDesc());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv1);
            desc = itemView.findViewById(R.id.dec);
        }
    }
}
