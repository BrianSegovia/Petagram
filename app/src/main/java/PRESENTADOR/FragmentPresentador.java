package PRESENTADOR;

import android.content.Context;

import com.example.mascotasrecyclerviewyactionview.Mascota;

import java.util.ArrayList;

import ActivityMain.ConstructorMascotas;
import ActivityMain.ViewFragment;
import ActivityMain.adaptador_Mascotas;

public class FragmentPresentador implements PresentadorDeFragment{

    private ViewFragment viewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList <Mascota> mascotas;



    public FragmentPresentador (ViewFragment presentadorDeFragment,Context context){
        this.context = context;
        this.viewFragment = presentadorDeFragment;
        obtenerContactos();
    }



    @Override
    public void obtenerContactos() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarContactosRV();

    }

    @Override
    public void mostrarContactosRV() {
        viewFragment.inicializarAdaptadorRV(viewFragment.crearAdaptador(mascotas));
        viewFragment.generarLinearLayoutVertical();
    }


}
