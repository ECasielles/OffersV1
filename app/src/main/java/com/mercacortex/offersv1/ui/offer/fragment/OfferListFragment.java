package com.mercacortex.offersv1.ui.offer.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.mercacortex.offersv1.R;
import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.base.BaseActivity;
import com.mercacortex.offersv1.ui.offer.adapter.OfferAdapter;
import com.mercacortex.offersv1.ui.offer.contract.OfferListContract;
import com.mercacortex.offersv1.ui.offer.presenter.OfferListPresenter;
import com.mercacortex.offersv1.utils.CommonDialog;

import java.util.List;


public class OfferListFragment extends ListFragment implements OfferListContract.View {
    //PARAMETROS
    public static final String TAG = "OfferListFragment";
    private OfferListListener callback;
    private OfferListContract.Presenter presenter;
    private OfferAdapter adapter;
    private Toolbar toolbar;
    private FloatingActionButton floatingActionButton;

    //CONSTRUCTOR ESTATICO
    public static OfferListFragment newInstance() {
        return new OfferListFragment();
    }

    //INICIO CICLO VIDA
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (OfferListListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Error: " + activity + " must implement OfferListListener.");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Menu
        setHasOptionsMenu(true);

        //Retener fragment
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflar vista + Crear elementos
        View view = inflater.inflate(R.layout.fragment_offer_list, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        floatingActionButton = view.findViewById(R.id.fab);

        //Adapter y presenter
        adapter = new OfferAdapter(getActivity());
        presenter = new OfferListPresenter(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Menu contextual
        registerForContextMenu(getListView());

        //Adapter
        setListAdapter(adapter);

        //Toolbar
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //Fab + listener añadir
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.addNewOffer(null);
            }
        });

        //Elemento + listener edición parcelable
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Parcelable parcel = (Parcelable) adapterView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable(Offer.TAG, parcel);
                callback.addNewOffer(bundle);
            }
        });
    }

    //MENU TOOLBAR
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_offer_list_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sort_ascending:
                break;
            case R.id.action_sort_descending:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //MENU CONTEXTUAL
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(R.string.offer_delete);
        getActivity().getMenuInflater().inflate(R.menu.menu_offer_list_fragment, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_item_delete:
                //AdapterContextMenuInfo <- getMenuInfo
                AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Offer offer = (Offer) getListView().getItemAtPosition(adapterContextMenuInfo.position);

                //Bundle + Dialog
                Bundle bundle = new Bundle();
                bundle.putString(CommonDialog.TITLE, "Eliminar oferta");
                bundle.putString(CommonDialog.MESSAGE, "¿Desea eliminar la oferta?");
                bundle.putParcelable(CommonDialog.OFFER, offer);
                Dialog dialog = CommonDialog.showConfirmationDialog(bundle, getActivity(), presenter);
                dialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    //RESTAURACION CICLO DE VIDA
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(OfferListPresenter.TAG, presenter);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null)
            this.presenter = (OfferListContract.Presenter) savedInstanceState.get(OfferListPresenter.TAG);
    }

    //COMUNICACION CON PRESENTER
    @Override
    public void setPresenter(OfferListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showOfferList(List offerListInteractor) {
        adapter.clear();
        adapter.addAll(offerListInteractor);
    }

    @Override
    public void showOfferDeletedMessage() {
        ((BaseActivity) callback).showMessage(R.string.offer_deleted_message);
    }

    //CICLO DE VIDA
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        adapter = null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //CONTRATO CON LA ACTIVITY
    public interface OfferListListener {
        void addNewOffer(Bundle bundle);
    }

}
