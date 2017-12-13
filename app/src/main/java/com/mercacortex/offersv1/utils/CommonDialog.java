package com.mercacortex.offersv1.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.mercacortex.offersv1.data.db.model.Offer;
import com.mercacortex.offersv1.ui.offer.contract.OfferListContract;



public class CommonDialog {
    public static final String TITLE = "TITLE";
    public static final String MESSAGE = "MESSAGE";
    public static final String OFFER = "OFFER";

    public static Dialog showConfirmationDialog(final Bundle bundle, FragmentActivity activity, final OfferListContract.Presenter presenter) {
        //Builder
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set: Message, Title, Positive, Negative
        builder
                .setMessage(bundle.getString(MESSAGE))
                .setTitle(bundle.getString(TITLE))
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.deleteItem((Offer) bundle.getParcelable(Offer.TAG));
                        dialogInterface.cancel();
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        return builder.create();
    }
}
