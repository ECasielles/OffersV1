package com.mercacortex.offersv1.ui.offer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.mercacortex.offersv1.R;
import com.mercacortex.offersv1.data.prefs.AppPreferencesHelper;
import com.mercacortex.offersv1.ui.OfferApplication;
import com.mercacortex.offersv1.ui.base.BaseActivity;
import com.mercacortex.offersv1.ui.offer.fragment.OfferAddEditFragment;
import com.mercacortex.offersv1.ui.offer.fragment.OfferListFragment;
import com.mercacortex.offersv1.ui.offer.presenter.OfferAddEditPresenter;
import com.mercacortex.offersv1.ui.offer.presenter.OfferListPresenter;

/**
 * Activity principal de ofertas.
 * TODO: OfferAddEditFragment. Código.
 * TODO: OfferListPresenter y OfferAddEditPresenter. Código.
 * TODO: OfferListInteractor y OfferAddEditInteractor. Código.
 * TODO: Estado dinámico. Sort.
 * TODO: Utils.
 * TODO: Preferences.
 */

public class OfferActivity extends BaseActivity implements OfferListFragment.OfferListListener,
        OfferAddEditFragment.OfferAddEditListener {

    OfferListFragment offerListFragment;
    OfferListPresenter offerListPresenter;
    OfferAddEditFragment offerAddEditFragment;
    OfferAddEditPresenter offerAddEditPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        offerListFragment = (OfferListFragment) getSupportFragmentManager().findFragmentByTag(OfferListFragment.TAG);
        if(offerListFragment == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            offerListFragment = OfferListFragment.newInstance();
            transaction.add(android.R.id.content, offerListFragment, OfferListFragment.TAG).commit();
        }

        offerListPresenter = new OfferListPresenter(offerListFragment);
        offerListFragment.setPresenter(offerListPresenter);
    }

    @Override
    public void addNewOffer(@Nullable Bundle bundle) {
        offerAddEditFragment = (OfferAddEditFragment) getSupportFragmentManager().findFragmentByTag(OfferAddEditFragment.TAG);
        if(offerAddEditFragment == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            offerAddEditFragment = OfferAddEditFragment.newInstance(bundle);
            transaction.addToBackStack(null);
            transaction.add(android.R.id.content, offerAddEditFragment, OfferListFragment.TAG).commit();
        }

        offerAddEditPresenter = new OfferAddEditPresenter(offerAddEditFragment);
        offerAddEditFragment.setPresenter(offerAddEditPresenter);
    }

    @Override
    public void listOffers() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showAppPreferences();
    }

    private void showAppPreferences() {
        AppPreferencesHelper appPreferencesHelper = ((OfferApplication) getApplicationContext()).getAppPreferencesHelper();
        appPreferencesHelper.setCurrentUserName("Lolita");
        String message = "Tu usuario de sesión es: " + appPreferencesHelper.getCurrentUserName();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
