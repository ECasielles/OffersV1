package com.mercacortex.offersv1.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.mercacortex.offersv1.R;
import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.offer.contract.OfferListContract;



public class CommonDialog {
    public static final String TITLE = "TITLE";
    public static final String MESSAGE = "MESSAGE";
    public static final String OFFER = "OFFER";

    public static Dialog showConfirmationDialog(final Bundle bundle, Context context, final OfferListContract.Presenter presenter) {
        //Builder
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //Set: Message, Title, Positive, Negative
        builder
                .setMessage(bundle.getString(MESSAGE))
                .setTitle(bundle.getString(TITLE))
                .setPositiveButton(R.string.offer_confirm_deletion, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.deleteItem((Offer) bundle.getParcelable(Offer.TAG));
                    }
                });
        return builder.create();
    }
}
