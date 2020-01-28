package com.informatique.informatiquetask.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.informatique.informatiquetask.data.models.HumanPartnerObjectPOJO;

import java.util.ArrayList;

/**
 * Created by abdelrahman on 28/01/20.
 */
public class HumanPartnersAdapter extends RecyclerView.Adapter<HumanPartnersViewHolder>{
    private ArrayList<HumanPartnerObjectPOJO> humanPartnerObjectPOJOArrayList;

    public HumanPartnersAdapter( ArrayList<HumanPartnerObjectPOJO> humanPartnerObjectPOJOArrayList) {
        this.humanPartnerObjectPOJOArrayList = humanPartnerObjectPOJOArrayList;
    }

    @NonNull
    @Override
    public HumanPartnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HumanPartnersViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull HumanPartnersViewHolder holder, int position) {
        HumanPartnerObjectPOJO partnerObjectPOJO = humanPartnerObjectPOJOArrayList.get(position);

        holder.item_nameTV.setText(partnerObjectPOJO.getNameAr());
        holder.item_nationality.setText(partnerObjectPOJO.getNationality());
        holder.item_nIN.setText(partnerObjectPOJO.getNIN());
    }

    @Override
    public int getItemCount() {
        return humanPartnerObjectPOJOArrayList.size();
    }
}
