package com.mercacortex.offersv1.ui.offer.contract;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.base.BasePresenter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Interfaz contrato entre OfferListFragment y OfferListPresenter
 */

public interface OfferListContract {

    interface View {
        void setPresenter(OfferListContract.Presenter presenter);

        void showOfferList(ArrayList<Offer> offerList);
        void showOfferDeletedMessage();

        void showOfferAddedMessage();

        void showOfferEditedMessage();
    }

    interface Presenter extends BasePresenter, Serializable {
        void deleteOffer(Offer offer);
    }

}
