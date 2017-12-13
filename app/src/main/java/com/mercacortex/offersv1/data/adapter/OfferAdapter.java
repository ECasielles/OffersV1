package com.mercacortex.offersv1.data.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercacortex.offersv1.R;
import com.mercacortex.offersv1.data.db.model.Offer;

import java.util.ArrayList;

public class OfferAdapter extends ArrayAdapter<Offer> {

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    public static final String TYPE = "TYPE";

    public OfferAdapter(@NonNull Context context) {
        super(context, R.layout.item_offer, new ArrayList<Offer>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = convertView;
        OfferHolder holder;
        if(rootView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            rootView = inflater.inflate(R.layout.item_offer, parent);
            holder = new OfferHolder();

            holder.imvType = rootView.findViewById(R.id.imvType);
            holder.txvDate = rootView.findViewById(R.id.txvDate);
            holder.txvShop = rootView.findViewById(R.id.txvShop);
            holder.txvName = rootView.findViewById(R.id.txvName);

            //SET TAG
            rootView.setTag(holder);
        } else
            holder = (OfferHolder) rootView.getTag();

        holder.imvType.setId(getItem(position).getImage());
        holder.txvDate.setText(getItem(position).getDate());
        holder.txvShop.setText(getItem(position).getShop());
        holder.txvName.setText(getItem(position).getName());

        return rootView;
    }

    //TODO: Falta ordenar y array dinámico
    /**
     * Ordena según criterio indicado
     * @param mode
     */
    public void sort(String mode) {
        switch (mode) {
            case ASC:
                break;
            case DESC:
                break;
            case TYPE:
                break;
        }
    }

    private class OfferHolder {
        ImageView imvType;
        TextView txvShop, txvName, txvDate;
    }
}
