package com.mercacortex.offersv1.ui.offer.presenter;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.offer.contract.OfferListContract;
import com.mercacortex.offersv1.ui.offer.interactor.OfferListInteractor;
import com.mercacortex.offersv1.ui.offer.interactor.OfferListInteractorImpl;

import java.util.List;

/**
 * Presenter de OfferListFragment
 */

public class OfferListPresenter implements OfferListContract.Presenter,
        OfferListInteractor.OnLoadFinishedListener {

    OfferListContract.View view;
    OfferListInteractor interactor;

    public OfferListPresenter(OfferListContract.View view) {
        this.view = view;
        this.interactor = new OfferListInteractorImpl(this);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onSuccess(List<Offer> offers) {

    }

    @Override
    public void loadOffers() {

    }

    @Override
    public void deleteItem(Offer parcelable) {

    }
}
