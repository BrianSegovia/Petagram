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

public class TodasLasMascotasRecyclerView extends Fragment implements DeActivityAFragment{



    private ArrayList<Mascota> mascotas                 = new ArrayList<Mascota>();
    private ArrayList<Mascota> mascotasFavoritas        = new ArrayList<Mascota>();
    private adaptador_Mascotas adaptador_mascotas        = new adaptador_Mascotas(mascotas);
    private Activity actividad;
    Comunicador comunicador;


    public TodasLasMascotasRecyclerView  (){

        mascotas.add(new Mascota(R.drawable.buddy_t,R.drawable.icons8_dog_bone_401,"\uD835\uDCD3\uD835\uDCF8\uD835\uDCF0\uD835\uDCF0\uD835\uDD02", "70", R.drawable.icons8_dog_bone_400));
        mascotas.add(new Mascota(R.drawable.cachorro_1,R.drawable.icons8_dog_bone_401,"\uD835\uDCD5\uD835\uDCF2\uD835\uDCFB\uD835\uDCFE\uD835\uDCF5\uD835\uDCEA\uD835\uDCF2\uD835\uDCFC", "10", R.drawable.icons8_dog_bone_400));
        mascotas.add(new Mascota(R.drawable.cachorro_2,R.drawable.icons8_dog_bone_401,"\uD835\uDCD2\uD835\uDCEA\uD835\uDCFB\uD835\uDCEA\uD835\uDCF6\uD835\uDCEE\uD835\uDCF5\uD835\uDCF8", "15", R.drawable.icons8_dog_bone_400));
        mascotas.add(new Mascota(R.drawable.cachorro_3,R.drawable.icons8_dog_bone_401,"\uD835\uDCDE\uD835\uDCFC\uD835\uDCF8", "20", R.drawable.icons8_dog_bone_400));
        mascotas.add(new Mascota(R.drawable.cachorro_4,R.drawable.icons8_dog_bone_401,"\uD835\uDCD2\uD835\uDCEA\uD835\uDCF7\uD835\uDCEE\uD835\uDCF5\uD835\uDCF8", "14", R.drawable.icons8_dog_bone_400));
        mascotas.add(new Mascota(R.drawable.cachorro_5,R.drawable.icons8_dog_bone_401,"\uD835\uDCE3\uD835\uDCF2\uD835\uDCF0\uD835\uDCFB\uD835\uDCEE", "21", R.drawable.icons8_dog_bone_400));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){



        View view                                     =  inflater.inflate(R.layout.fragment_todas_las_mascotas_recyclerview,container,false);
        RecyclerView MascotasTotales                 = (RecyclerView) view.findViewById(R.id.MascotasTotales);
        LinearLayoutManager linearLayoutManager      = new LinearLayoutManager(getActivity());
        ImageButton camara = (ImageButton) view.findViewById(R.id.imageButton2);


        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MascotasTotales.setLayoutManager(linearLayoutManager);
        MascotasTotales.setAdapter(adaptador_mascotas);

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
}
