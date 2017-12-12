package com.mercacortex.offersv1.ui.offer.interactor;

/**
 * Created by icenri on 12/12/17.
 */

public interface OfferAddEditInteractor {

    void validateOffer(String[] params);
    void addOffer(String[] params);
    void editOffer(String[] params);

    interface OnAddEditFinishedListener {
        void onNameEmptyError();
        void onShopEmptyError();
        void onDateNameLengthError();
        void onSuccess(int message);
        void onFailure(int message);
    }

}
