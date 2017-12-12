package com.mercacortex.offersv1.data.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercacortex.offersv1.R;
import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.data.db.repository.OfferRepository;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    public static final String TYPE = "TYPE";
    private List<Offer> offers;

    public OfferAdapter() {
        offers = OfferRepository.getInstance();
    }

    /**
     * Infla la vista. Crea un holder con los elementos de item.
     * @param parent
     * @param viewType
     * @return Devuelve el objeto holder.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_offer, parent);
        ViewHolder holder = new ViewHolder(rootView);
        holder.imvType = rootView.findViewById(R.id.imvType);
        holder.txvDate = rootView.findViewById(R.id.txvDate);
        holder.txvShop = rootView.findViewById(R.id.txvShop);
        holder.txvName = rootView.findViewById(R.id.txvName);
        return holder;
    }

    /**
     * Guarda los valores en los elementos del holder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imvType.setId(offers.get(position).getImage());
        holder.txvDate.setText(offers.get(position).getDate());
        holder.txvShop.setText(offers.get(position).getShop());
        holder.txvName.setText(offers.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return offers.size();
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvType;
        TextView txvShop, txvName, txvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            imvType = itemView.findViewById(R.id.imvType);
            txvDate = itemView.findViewById(R.id.txvDate);
            txvShop = itemView.findViewById(R.id.txvShop);
            txvName = itemView.findViewById(R.id.txvName);
        }
    }
}
