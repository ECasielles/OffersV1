package com.mercacortex.offersv1.ui.offer.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mercacortex.offersv1.R;
import com.mercacortex.offersv1.ui.offer.contract.OfferAddEditContract;

public class OfferAddEditFragment extends Fragment implements OfferAddEditContract.View {
    //PARAMETROS
    public static final String TAG = "OfferAddEditFragment";
    private OfferAddEditFragment.OfferAddEditListener callBack;
    private OfferAddEditContract.Presenter presenter;
    private TextInputLayout tilName, tilShop, tilDate;

    //CONSTRUCTOR ESTATICO
    public static OfferAddEditFragment newInstance(Bundle arguments) {
        OfferAddEditFragment offerAddEditFragment = new OfferAddEditFragment();
        if (arguments != null)
            offerAddEditFragment.setArguments(arguments);
        return offerAddEditFragment;
    }

    //INICIO CICLO DE VIDA
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callBack = (OfferAddEditListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity + " must implement OfferAddEditListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Retain
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_offer_add_edit, container, false);
        tilName = rootView.findViewById(R.id.tilName);
        tilShop = rootView.findViewById(R.id.tilShop);
        tilDate = rootView.findViewById(R.id.tilDate);
        return rootView;
    }

    //COMUNICACION CON EL PRESENTER
    @Override
    public void setPresenter(OfferAddEditContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToOfferList() {
        callBack.listOffers();
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

    //CONTRATO CON LA ACTIVITY
    public interface OfferAddEditListener {
        void listOffers();
    }

}
