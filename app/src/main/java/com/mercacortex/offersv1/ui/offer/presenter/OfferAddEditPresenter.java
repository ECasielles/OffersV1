package com.mercacortex.offersv1.ui.offer.presenter;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.offer.contract.OfferAddEditContract;
import com.mercacortex.offersv1.ui.offer.interactor.OfferAddEditInteractor;
import com.mercacortex.offersv1.ui.offer.interactor.OfferAddEditInteractorImpl;

/**
 * Presenter de OfferAddEditFragment
 */

public class OfferAddEditPresenter implements OfferAddEditContract.Presenter,
        OfferAddEditInteractor.OnAddEditFinishedListener {

    OfferAddEditContract.View view;
    OfferAddEditInteractor interactor;

    public OfferAddEditPresenter(OfferAddEditContract.View view) {
        this.view = view;
        this.interactor = new OfferAddEditInteractorImpl(this);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onNameEmptyError() {

    }

    @Override
    public void onShopEmptyError() {

    }

    @Override
    public void onDateNameLengthError() {

    }

    @Override
    public void onSuccess(int message) {

    }

    @Override
    public void onFailure(int message) {

    }

    @Override
    public void saveOffer(String[] params) {

    }

    @Override
    public void editOffer(Offer offer, String[] params) {

    }

}
