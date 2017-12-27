package com.mercacortex.offersv1.ui.offer.interactor;

import com.mercacortex.offersv1.data.db.model.Offer;

import java.util.ArrayList;

/**
 * Interfaz contrato entre OfferListInteractorImpl y OfferListPresenter
 */

public interface OfferListInteractor {

    void deleteOffer(Offer offer);

    interface OnLoadFinishedListener {
        void onOfferDeleted(ArrayList<Offer> offers);
    }

}
