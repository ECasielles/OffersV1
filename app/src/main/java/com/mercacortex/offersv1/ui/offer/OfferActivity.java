package com.mercacortex.offersv1.ui.offer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.mercacortex.offersv1.R;
import com.mercacortex.offersv1.data.adapter.OfferAdapter;

/**
 * Activity principal de ofertas.
 * TODO: OfferListFragment y OfferAddEditFragment. Vista y código.
 * TODO: OfferListPresenter y OfferAddEditPresenter. Terminar código.
 * TODO: OfferListInteractor y OfferAddEditInteractor. Terminar código.
 * TODO: OfferActivity. Añadir Fragments.
 * TODO: OfferAdapter. Guardar estado dinámico.
 * TODO: Utils. Crear paquete y clase CommonUtils y CommonDialog.
 * TODO: ...
 */

public class OfferActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;
    RecyclerView recyclerView;
    OfferAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAdd = findViewById(R.id.fab);
        recyclerView = findViewById(android.R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OfferAdapter();
        recyclerView.setAdapter(adapter);
    }

    //onClick
    public void onClick(View view) {
        //...
    }

    //onActivityResult
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sort_ascending:
                adapter.sort(OfferAdapter.ASC);
                break;
            case R.id.action_sort_descending:
                adapter.sort(OfferAdapter.DESC);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
