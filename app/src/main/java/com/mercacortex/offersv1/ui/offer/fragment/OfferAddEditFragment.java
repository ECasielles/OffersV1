package com.mercacortex.offersv1.ui.offer.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    private FloatingActionButton fab;
    private Toolbar toolbar;

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
        fab = rootView.findViewById(R.id.fab);
        toolbar = rootView.findViewById(R.id.toolbar);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Toolbar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        //Boton + listener añadir
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addOffer(
                        tilName.getEditText().getText().toString(),
                        tilShop.getEditText().getText().toString(),
                        tilDate.getEditText().getText().toString()
                );
            }
        });
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
    public void showNameInvalidError() {
        tilName.setError(getContext().getResources().getString(R.string.offer_add_edit_name_error));
    }

    @Override
    public void showShopInvalidError() {
        tilShop.setError(getContext().getResources().getString(R.string.offer_add_edit_shop_error));
    }

    @Override
    public void showDateInvalidError() {
        tilDate.setError(getContext().getResources().getString(R.string.offer_add_edit_date_error));
    }

    @Override
    public void showNameEmptyError() {
        tilName.setError(getContext().getResources().getString(R.string.offer_add_edit_name_empty_error));
    }

    @Override
    public void showShopEmptyError() {
        tilShop.setError(getContext().getResources().getString(R.string.offer_add_edit_shop_empty_error));
    }

    @Override
    public void showDateEmptyError() {
        tilDate.setError(getContext().getResources().getString(R.string.offer_add_edit_date_empty_error));
    }

    //CICLO DE VIDA
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    //CONTRATO CON LA ACTIVITY
    public interface OfferAddEditListener {
        void listOffers();
    }
}
