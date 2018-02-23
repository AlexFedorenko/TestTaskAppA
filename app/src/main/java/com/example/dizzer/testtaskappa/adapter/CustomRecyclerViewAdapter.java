package com.example.dizzer.testtaskappa.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dizzer.testtaskappa.R;
import com.example.dizzer.testtaskappa.constant.CustomConstant;
import com.example.dizzer.testtaskappa.model.LinkModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dizzer on 2/23/2018.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder> {

    List<LinkModel> linkModels = new ArrayList<>();

    public CustomRecyclerViewAdapter(List<LinkModel> linkModels) {
        this.linkModels = linkModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Date date = new Date(linkModels.get(position).getTime());
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        int status = linkModels.get(position).getStatus();

        holder.textViewDate.setText(formatForDateNow.format(date));
        holder.textViewLink.setText(linkModels.get(position).getLink());

        switch(status){
            case CustomConstant.STATUS_DOWNLOADED:
                holder.view.setBackgroundColor(Color.GREEN);
                break;
            case CustomConstant.STATUS_ERROR:
                holder.view.setBackgroundColor(Color.RED);
                break;
            default:
                holder.view.setBackgroundColor(Color.GRAY);
        }

    }

    @Override
    public int getItemCount() {
        return linkModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewLink;
        private TextView textViewDate;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textViewLink = (TextView) itemView.findViewById(R.id.rvi_tv_link_address);
            textViewDate = (TextView) itemView.findViewById(R.id.rvi_tv_link_date);
        }
    }
}
