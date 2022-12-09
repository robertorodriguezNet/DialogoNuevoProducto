package net.robertorodriguez.dialogo;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import net.robertorodriguez.dialogo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    // Declaramos el diálogo de nuevo producto
    DialogoNuevoProducto dialogoNuevoProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoNuevoProducto = new DialogoNuevoProducto();
                dialogoNuevoProducto.show( getSupportFragmentManager(), "DialogoNuevoProducto");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Método para mostrar el diálogo
     */
    @Deprecated
    private void displayDialog(){
        /*
        // Declaramos los dos botones que tenemos en el layout
        Button btn_agregarProducto, btn_cancelarProducto;

        // Conectamos con el diseño
        dialogoNuevoProducto.setContentView( R.layout.dialogo_nuevo_producto);

        // Inicializamos los botones
        btn_agregarProducto = dialogoNuevoProducto.findViewById(R.id.np_btn_Agregar);
        btn_cancelarProducto = dialogoNuevoProducto.findViewById(R.id.np_btn_cancelar);

        //Asignamos los eventos
        btn_agregarProducto.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick( View v ){
                Toast.makeText(MainActivity.this, "Guardando", Toast.LENGTH_SHORT).show();
            }
        });
        btn_cancelarProducto.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick( View v ){
                Toast.makeText(MainActivity.this, "Cancelar", Toast.LENGTH_SHORT).show();
            }
        });

        dialogoNuevoProducto.show();

         */

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}