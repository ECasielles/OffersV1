package com.mercacortex.offersv1.ui.offer.contract;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.base.BasePresenter;
import com.mercacortex.offersv1.ui.base.BaseView;

import java.io.Serializable;

/**
 * Interfaz contrato entre OfferAddEditFragment y OfferActivity
 */

public interface OfferAddEditContract {

    interface View extends BaseView {
        void navigateToOfferList();
        void setNameEmptyError();
        void setShopEmptyError();
        void setDateEmptyError();
        // ... Más errores.
        // Ver si se hace de otra forma.
    }

    interface Presenter extends BasePresenter, Serializable {
        void saveOffer(String[] params);
        void editOffer(Offer offer, String[] params);
    }

}
