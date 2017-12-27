package com.mercacortex.offersv1.ui.offer.presenter;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.offer.contract.OfferListContract;
import com.mercacortex.offersv1.ui.offer.interactor.OfferListInteractor;
import com.mercacortex.offersv1.ui.offer.interactor.OfferListInteractorImpl;

import java.util.ArrayList;

/**
 * Presenter de OfferListFragment
 */

public class OfferListPresenter implements OfferListContract.Presenter,
        OfferListInteractor.OnLoadFinishedListener {
    public static final String TAG = "OfferListPresenter";
    private OfferListContract.View view;
    private OfferListInteractor interactor;

    public OfferListPresenter(OfferListContract.View view) {
        this.view = view;
        this.interactor = new OfferListInteractorImpl(this);
    }

    //COMUNICACION CON INTERACTOR
    @Override
    public void deleteOffer(Offer offer) {
        interactor.deleteOffer(offer);
    }

    @Override
    public void onOfferDeleted(ArrayList<Offer> offerList) {
        view.showOfferList(offerList);
        view.showOfferDeletedMessage();
    }

    //CICLO DE VIDA
    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

}
