package com.mercacortex.offersv1.ui.offer.interactor;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.data.db.repository.OfferRepository;

/**
 * Interactor de OfferListFragment
 */

public class OfferListInteractorImpl implements OfferListInteractor {

    private final OnLoadFinishedListener listener;

    public OfferListInteractorImpl(OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void deleteOffer(Offer offer) {
        listener.onOfferDeleted(OfferRepository.getInstance().delete(offer));
    }

}
