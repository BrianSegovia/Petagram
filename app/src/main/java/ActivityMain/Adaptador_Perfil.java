package ActivityMain;

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

public class Adaptador_Perfil extends RecyclerView.Adapter <Adaptador_Perfil.MascotaViewHolder> {



    private ArrayList <Mascota> mascotas;


    public Adaptador_Perfil (ArrayList<Mascota> mascotas){

        this.mascotas = mascotas;
    }


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos_y_likes,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        holder.fotoCachorro.setImageResource(mascota.getFotoCachorro());
        holder.cantidadDeLikes.setText(mascota.getCantidadDeLikes());
        }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoCachorro;
        private TextView cantidadDeLikes;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoCachorro  =(ImageView) itemView.findViewById(R.id.imageView3);
            cantidadDeLikes = (TextView) itemView.findViewById(R.id.textView5);
        }
    }

}