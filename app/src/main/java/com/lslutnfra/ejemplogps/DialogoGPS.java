package com.lslutnfra.ejemplogps;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class DialogoGPS extends DialogFragment {

    private MainActivity a;

    public DialogoGPS(MainActivity a)
    {
        this.a=a;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // creamos el dialogo
        Builder builder = new AlertDialog.Builder(a);
        builder.setTitle("Alerta!");
        builder.setMessage("Se debe encender el GPS");
        builder.setPositiveButton("Aceptar", a);
        builder.setNegativeButton("Cancelar", null);
        AlertDialog ad = builder.create();

        return ad;
    }
}
