package com.mercacortex.offersv1.ui.offer.interactor;

import com.mercacortex.offersv1.R;
import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.data.db.repository.OfferRepository;

/**
 * Interactor de OfferAddEditFragment
 */

public class OfferAddEditInteractorImpl implements OfferAddEditInteractor {

    OnAddEditFinishedListener listener;

    public OfferAddEditInteractorImpl(OnAddEditFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void validateOffer(String[] params) {

    }

    @Override
    public void addOffer(String[] params) {
        boolean result = true;
        //Falta validar
        if(result) {
            //Éxito
            OfferRepository.getInstance().add(new Offer(params[0], params[1], params[2], R.drawable.ic_launcher_foreground, 0));
            listener.onSuccess(R.string.offer_added);
        } else
            //Fallo
            listener.onFailure(R.string.offer_added_failure);
    }

    @Override
    public void editOffer(String[] params) {
        //Falta validar
        //Falta añadir
            //Éxito
            //Fallo
    }
}
