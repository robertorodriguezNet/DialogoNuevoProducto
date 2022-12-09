package net.robertorodriguez.dialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoNuevoProducto extends DialogFragment {

    /**
     * Método estático que devuelve el diálogo
     * @param
     * @return
     */
    static DialogoNuevoProducto newInstacnce(){

        DialogoNuevoProducto d = new DialogoNuevoProducto();
        return d;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Usamos la clase Builder para construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder( getActivity() );

        //Herramienta para cargar el layout
        LayoutInflater inflater = getActivity().getLayoutInflater();
        //Cargamos el layout en el diálogo
        builder.setView( inflater.inflate(R.layout.dialogo_nuevo_producto, null));

        builder.setMessage( "Agregar nuevo producto")
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Guardado", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });

         return builder.create();

    }
}
