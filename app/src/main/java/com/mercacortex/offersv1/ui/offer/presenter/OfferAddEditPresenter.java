package com.mercacortex.offersv1.ui.offer.presenter;

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

    //COMUNICACION CON EL INTERACTOR
    @Override
    public void addOffer(String name, String shop, String date) {
        interactor.addOffer(name, shop, date);
    }

    //COMUNICACION CON LA VISTA
    @Override
    public void onNameInvalidError() {
        view.showNameInvalidError();
    }
    @Override
    public void onShopInvalidError() {
        view.showShopInvalidError();
    }
    @Override
    public void onDateInvalidError() {
        view.showDateInvalidError();
    }
    @Override
    public void onNameEmptyError() {
        view.showNameInvalidError();
    }
    @Override
    public void onShopEmptyError() {
        view.showShopEmptyError();
    }
    @Override
    public void onDateEmptyError() {
        view.showDateInvalidError();
    }

    //CICLO DE VIDA
    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

}
