package com.mercacortex.offersv1.ui.offer.interactor;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.data.db.repository.OfferRepository;
import com.mercacortex.offersv1.utils.CommonUtils;

/**
 * Interactor de OfferAddEditFragment
 */

public class OfferAddEditInteractorImpl implements OfferAddEditInteractor {

    OnAddEditFinishedListener listener;

    public OfferAddEditInteractorImpl(OnAddEditFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean validateOffer(String name, String shop, String date) {
        if (name.isEmpty()) {
            listener.onNameEmptyError();
            return false;
        }
        if (!CommonUtils.isNameValid(name)) {
            listener.onNameInvalidError();
            return false;
        }
        if (shop.isEmpty()) {
            listener.onShopEmptyError();
            return false;
        }
        if (!CommonUtils.isShopValid(shop)) {
            listener.onShopInvalidError();
            return false;
        }
        if (date.isEmpty()) {
            listener.onDateEmptyError();
            return false;
        }
        if (!CommonUtils.isDateValid(date)) {
            listener.onDateInvalidError();
            return false;
        }
        return true;
    }

    @Override
    public void addOffer(String name, String shop, String date) {
        if (validateOffer(name, shop, date)) {
            OfferRepository.getInstance().add(new Offer(name, shop, date, 0, 0));
            listener.onOfferAdded();
        }
    }

    @Override
    public void editOffer(Offer offer, String name, String shop, String date) {
        if (validateOffer(name, shop, date)) {
            OfferRepository.getInstance().replace(offer, new Offer(name, shop, date, 0, 0));
            listener.onOfferEdited();
        }
    }
}
