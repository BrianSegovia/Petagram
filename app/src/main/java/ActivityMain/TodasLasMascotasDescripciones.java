package ActivityMain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasrecyclerviewyactionview.Mascota;
import com.example.mascotasrecyclerviewyactionview.R;

import java.util.ArrayList;

import MascotasFavoritas.MascotasFavoritas;

public class TodasLasMascotasDescripciones extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_todas_las_mascotas_descripciones,container,false);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewFotos);

        ArrayList <Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.buddy_t,"7"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"10"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"8"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"11"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"13"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"25"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"29"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"30"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"35"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"47"));
        mascotas.add(new Mascota(R.drawable.buddy_t,"3"));



       GridLayoutManager linearLayoutManager = new GridLayoutManager (getContext(),2);
        linearLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        Adaptador_Perfil adaptador_mascotas = new Adaptador_Perfil(mascotas);
        recyclerView.setAdapter(adaptador_mascotas);




        return view;
    }

}
