package net.robertorodriguez.dialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoNuevoProducto extends DialogFragment {

    // Definimos un oyente para el evento "Guardar producto".
    OnNuevoProductoListener oyente;

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
                        //Agregamos el oyente para el botón
                        oyente.onGuardarProductoClickListener();
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

    /**
     * Método que comprueba que la activity que carga el
     * implementa la interfaz .
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verificamos que la actividad host implementa la llamada
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            oyente = (OnNuevoProductoListener) context;
        } catch (ClassCastException e) {
            // Si la actividad no implementa la interfaz, se lanza excepción
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }

}
