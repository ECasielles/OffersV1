package com.mercacortex.offersv1.ui.offer.interactor;

import com.mercacortex.offersv1.data.db.model.Offer;

import java.util.List;

/**
 * Interfaz contrato entre OfferListInteractorImpl y OfferListPresenter
 */

public interface OfferListInteractor {

    void deleteOffer(Offer offer);
    void loadOffers();

    interface OnLoadFinishedListener {
        void onSuccess(List<Offer> offers);
    }

}
