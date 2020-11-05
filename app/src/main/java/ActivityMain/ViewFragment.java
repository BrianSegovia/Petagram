package ActivityMain;

import com.example.mascotasrecyclerviewyactionview.Mascota;

import java.util.ArrayList;

public interface ViewFragment {

    public void generarLinearLayoutVertical();

    public adaptador_Mascotas crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(adaptador_Mascotas adaptador);

}
