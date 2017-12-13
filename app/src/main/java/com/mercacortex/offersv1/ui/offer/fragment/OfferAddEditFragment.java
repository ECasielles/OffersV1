package com.mercacortex.offersv1.ui.offer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mercacortex.offersv1.ui.base.BasePresenter;
import com.mercacortex.offersv1.ui.offer.contract.OfferAddEditContract;

public class OfferAddEditFragment extends Fragment implements OfferAddEditContract.View {
    public static final String TAG = "OfferAddEditFragment";

    public interface OfferAddEditListener {
        void listOffers();
    }

    public static OfferAddEditFragment newInstance(Bundle arguments) {
        return null;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public void navigateToOfferList() {

    }

    @Override
    public void setNameEmptyError() {

    }

    @Override
    public void setShopEmptyError() {

    }

    @Override
    public void setDateEmptyError() {

    }

}
