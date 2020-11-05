package ActivityMain;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mascotasrecyclerviewyactionview.Mascota;
import com.example.mascotasrecyclerviewyactionview.R;
import java.util.ArrayList;

import PRESENTADOR.FragmentPresentador;
import PRESENTADOR.PresentadorDeFragment;

public class TodasLasMascotasRecyclerView extends Fragment implements DeActivityAFragment , ViewFragment{



    private ArrayList<Mascota> mascotas                 = new ArrayList<Mascota>();
    private ArrayList<Mascota> mascotasFavoritas        = new ArrayList<Mascota>();
    private adaptador_Mascotas adaptador_mascotas;
    private Activity actividad;
    private RecyclerView MascotasTotales;
    Comunicador comunicador;
    private PresentadorDeFragment presentadorDeFragment;


    public TodasLasMascotasRecyclerView  (){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){



        View view                                     =  inflater.inflate(R.layout.fragment_todas_las_mascotas_recyclerview,container,false);
        ImageButton camara = (ImageButton) view.findViewById(R.id.imageButton2);
        MascotasTotales = (RecyclerView) view.findViewById(R.id.MascotasTotales);


        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        presentadorDeFragment = new FragmentPresentador(this,getContext());
        generarLinearLayoutVertical();
        inicializarAdaptadorRV(adaptador_mascotas);

        return view;

    }




    @Override
    public void onAttach(@NonNull Context context) {

        comunicador = (Comunicador) context;

        super.onAttach(context);
    }


    @Override
    public void EstrellaPresionada() {
        comunicador.enviarLista(adaptador_mascotas.obtenerMascotasFavoritas());
    }

    @Override
    public void perritoEliminado(String nombre) {

        ArrayList<Mascota> mascotas = this.mascotas;
        ArrayList<Mascota> mascotasDeVuelta = new ArrayList<Mascota>();

        for (Mascota mascota : mascotas){

            if ( mascota.getNombreDelCachorro().equals(nombre) ){
                mascota.setTipoDeHueso(R.drawable.icons8_dog_bone_401);
                mascota.setTipoDeHuesolikes(0);
            }

            mascotasDeVuelta.add(mascota);
        }

        setMascotas(mascotasDeVuelta);

    }


    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }




    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager linearLayoutManager      = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MascotasTotales.setLayoutManager(linearLayoutManager);
    }




    @Override
    public adaptador_Mascotas crearAdaptador(ArrayList<Mascota> mascotas) {
        this.adaptador_mascotas = new adaptador_Mascotas(mascotas, getActivity()  );
        return adaptador_mascotas;
    }





    @Override
    public void inicializarAdaptadorRV(adaptador_Mascotas adaptador) {
        MascotasTotales.setAdapter(adaptador_mascotas);
    }
}
