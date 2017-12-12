package com.mercacortex.offersv1.data.db.repository;

import com.mercacortex.offersv1.R;
import com.mercacortex.offersv1.data.db.model.Offer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Repositorio de ofertas
 */

public class OfferRepository extends ArrayList<Offer> {

    private static OfferRepository repository;
    private ArrayList<Offer> offers;

    static {
        repository = new OfferRepository();
    }


    private OfferRepository() {
        this.offers = new ArrayList<>();
        init();
    }

    private void init() {
        repository.add(new Offer("Chanclas", "Havaianas", "1999/12/12", R.drawable.ic_launcher_background, 0));
        repository.add(new Offer("Migas", "Todo a 10", "1994/12/12", R.drawable.ic_launcher_background, 2));
        repository.add(new Offer("Turbo", "Nada de nai", "1997/07/10", R.drawable.ic_launcher_background, 1));
        repository.add(new Offer("Landas", "Shtrrictrla", "1989/10/12", R.drawable.ic_launcher_background, 1));
        repository.add(new Offer("Porongos", "Harafalafa", "1982/02/12", R.drawable.ic_launcher_background, 2));
        repository.add(new Offer("Chuflas", "Ikea", "1986/01/01", R.drawable.ic_launcher_background, 3));
    }

    public static OfferRepository getInstance() {
        if(repository == null)
            repository = new OfferRepository();
        return repository;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public boolean delete(Offer offer) {
        boolean result = false;
        Iterator<Offer> iterator = offers.iterator();
        while (iterator.hasNext())
            if(iterator.next().equals(offer)) {
                iterator.remove();
                result = true;
                break;
            }
        return result;
    }
}
