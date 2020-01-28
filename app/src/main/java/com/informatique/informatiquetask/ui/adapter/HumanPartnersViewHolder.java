package com.informatique.informatiquetask.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.informatique.informatiquetask.R;

/**
 * Created by abdelrahman on 28/01/20.
 */
 class HumanPartnersViewHolder extends RecyclerView.ViewHolder {
    TextView item_nameTV, item_nationality,item_nIN;

    HumanPartnersViewHolder(@NonNull ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.human_partners_list_items,parent,false));

        item_nameTV= itemView.findViewById(R.id.item_nameTV);
        item_nationality= itemView.findViewById(R.id.item_nationalityTV);
        item_nIN= itemView.findViewById(R.id.item_nINTV);

    }
}
