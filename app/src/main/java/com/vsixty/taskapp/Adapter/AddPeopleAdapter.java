package com.vsixty.taskapp.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vsixty.taskapp.API.Model.CommonModel;
import com.vsixty.taskapp.R;

import java.util.ArrayList;

public class AddPeopleAdapter extends RecyclerView.Adapter<AddPeopleAdapter.ViewHolder> {

    Activity activity;
    public ArrayList<CommonModel> commonModels;

    public AddPeopleAdapter(Activity activity, ArrayList<CommonModel> commonModels) {
        this.activity = activity;
        this.commonModels = commonModels;
    }

    @NonNull
    @Override
    public AddPeopleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.addpeople_adapter, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final AddPeopleAdapter.ViewHolder holder, int position) {


        holder.tvStaffName.setText(commonModels.get(position).getName());
        holder.tvDesignation.setText(commonModels.get(position).getDesignation());


        final CommonModel model = commonModels.get(position);


        holder.rlAddPeopleLayout.setBackgroundColor(model.isSelected() ? Color.BLACK : Color.parseColor("#ffffff"));
        holder.tvStaffName.setTextColor(model.isSelected() ? Color.parseColor("#323232") : Color.BLACK);
        holder.tvDesignation.setTextColor(model.isSelected() ? Color.parseColor("#323232") : Color.BLACK);

        holder.tvStaffName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setSelected(!model.isSelected());
                holder.rlAddPeopleLayout.setBackgroundColor(model.isSelected() ? Color.parseColor("#1A000000") : Color.parseColor("#ffffff"));
                holder.tvStaffName.setTextColor(model.isSelected() ? Color.parseColor("#0DA5F3") : Color.parseColor("#323232"));
                holder.tvDesignation.setTextColor(model.isSelected() ? Color.parseColor("#0DA5F3") : Color.parseColor("#323232"));


            }
        });


    }

    @Override
    public int getItemCount() {
        return commonModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStaffName, tvDesignation;
        RelativeLayout rlAddPeopleLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvStaffName = itemView.findViewById(R.id.tvStaffName);
            tvDesignation = itemView.findViewById(R.id.tvDesignation);
            rlAddPeopleLayout = itemView.findViewById(R.id.rlAddPeopleLayout);
        }
    }
}
