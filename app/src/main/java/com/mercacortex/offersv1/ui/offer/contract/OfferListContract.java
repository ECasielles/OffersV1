package com.mercacortex.offersv1.ui.offer.contract;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.base.BasePresenter;
import com.mercacortex.offersv1.ui.base.BaseView;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz contrato entre OfferListFragment y OfferListPresenter
 */

public interface OfferListContract {

    interface View extends BaseView {
        void showOfferList(List offerListInteractor);
        void showMessage(String message);
        void showDeletedMessage(String message);
    }

    interface Presenter extends BasePresenter, Serializable {
        void loadOffers();
        void deleteItem(Offer parcelable);
    }

}
