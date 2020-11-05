package ActivityMain;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasrecyclerviewyactionview.Mascota;
import com.example.mascotasrecyclerviewyactionview.R;

import java.util.ArrayList;

public class adaptador_Mascotas extends RecyclerView.Adapter <adaptador_Mascotas.MascotaViewHolder> {



    private ArrayList <Mascota> mascotas;
    private Activity activity;

    public adaptador_Mascotas (ArrayList<Mascota> mascotas ,  Activity activity){

        this.mascotas = mascotas;
        this.activity = activity;

    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        holder.fotoCachorro.setImageResource(mascota.getFotoCachorro());
        holder.nombreDelCachorro.setText(mascota.getNombreDelCachorro());
        holder.fotoTipoDeHueso.setImageResource(mascota.getTipoDeHueso());
        holder.cantidadDeLikes.setText(mascota.getCantidadDeLikes());
        holder.fotoCantidadDLikes.setImageResource(mascota.getFotoHuesoDorado());
        holder.fotoTipoDeHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mascota mascota1  = mascotas.get(position);
                if(mascota.getTipoDeHuesolikes() == 0){
                    mascota.setTipoDeHueso(R.drawable.icons8_dog_bone_401);
                    mascota.setTipoDeHuesolikes(0);
                    int aux = Integer.parseInt( mascota.getCantidadDeLikes());
                    aux --;
                    mascota.setCantidadDeLikes(Integer.toString(aux));

                } else {

                    mascota.setTipoDeHueso(R.drawable.icons8_dog_bone_400);
                    mascota.setTipoDeHuesolikes(1);
                    int aux = Integer.parseInt( mascota.getCantidadDeLikes());
                    aux ++;
                    mascota.setCantidadDeLikes(Integer.toString(aux));


                }
                holder.fotoTipoDeHueso.setImageResource(mascota.getTipoDeHueso());
                holder.cantidadDeLikes.setText(mascota.getCantidadDeLikes());


            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoCachorro;
        private ImageView fotoTipoDeHueso;
        private ImageView fotoCantidadDLikes;
        private TextView nombreDelCachorro;
        private TextView cantidadDeLikes;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoCachorro  =(ImageView) itemView.findViewById(R.id.cachorro);
            fotoTipoDeHueso = (ImageView) itemView.findViewById(R.id.tipoDeHueso);
            fotoCantidadDLikes = (ImageView) itemView.findViewById(R.id.huesoDorado);
            nombreDelCachorro = (TextView) itemView.findViewById(R.id.nombreDelCachorro);
            cantidadDeLikes = (TextView) itemView.findViewById(R.id.cantidadDeLikes);
        }
    }

    public ArrayList <Mascota> obtenerMascotasFavoritas(){

        return this.mascotas;

    }


}
