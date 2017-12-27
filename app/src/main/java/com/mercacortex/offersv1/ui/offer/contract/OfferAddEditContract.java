package com.mercacortex.offersv1.ui.offer.contract;

import com.mercacortex.offersv1.ui.base.BasePresenter;

import java.io.Serializable;

/**
 * Interfaz contrato entre OfferAddEditFragment y OfferActivity
 */

public interface OfferAddEditContract {

    interface View {
        void setPresenter(OfferAddEditContract.Presenter presenter);

        void showNameInvalidError();

        void showShopInvalidError();

        void showDateInvalidError();

        void showNameEmptyError();

        void showShopEmptyError();

        void showDateEmptyError();

        void navigateToOfferList();
        // Ver si se hace de otra forma.
    }

    interface Presenter extends BasePresenter, Serializable {
        void addOffer(String name, String shop, String date);
    }

}
