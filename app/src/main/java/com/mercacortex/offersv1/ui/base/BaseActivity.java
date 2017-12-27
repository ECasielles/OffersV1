package com.mercacortex.offersv1.ui.base;


import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void showMessage(int resId) {
        Snackbar.make(findViewById(android.R.id.content), getResources().getString(resId),
                Snackbar.LENGTH_SHORT).show();
    }

}
