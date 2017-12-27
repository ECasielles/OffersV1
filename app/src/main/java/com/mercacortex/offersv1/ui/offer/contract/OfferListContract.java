package com.mercacortex.offersv1.ui.offer.contract;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.base.BasePresenter;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz contrato entre OfferListFragment y OfferListPresenter
 */

public interface OfferListContract {

    interface View {
        void setPresenter(OfferListContract.Presenter presenter);
        void showOfferList(List offerListInteractor);

        void showOfferDeletedMessage();
    }

    interface Presenter extends BasePresenter, Serializable {
        void loadOfferList();
        void deleteItem(Offer parcelable);
    }

}
