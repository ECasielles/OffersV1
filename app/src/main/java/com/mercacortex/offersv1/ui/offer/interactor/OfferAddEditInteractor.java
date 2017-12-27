package com.mercacortex.offersv1.ui.offer.interactor;

import com.mercacortex.offersv1.data.db.model.Offer;

/**
 * Created by icenri on 12/12/17.
 */

public interface OfferAddEditInteractor {

    boolean validateOffer(String name, String shop, String date);

    void addOffer(String name, String shop, String date);

    void editOffer(Offer offer, String name, String shop, String date);

    interface OnAddEditFinishedListener {
        void onOfferAdded();

        void onOfferEdited();

        void onNameInvalidError();

        void onShopInvalidError();

        void onDateInvalidError();
        void onNameEmptyError();
        void onShopEmptyError();

        void onDateEmptyError();
    }

}
