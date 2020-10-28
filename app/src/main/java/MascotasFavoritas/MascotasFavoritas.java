package MascotasFavoritas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasrecyclerviewyactionview.Mascota;
import com.example.mascotasrecyclerviewyactionview.R;

import java.util.ArrayList;

import ActivityMain.Comunicador;
import ActivityMain.DeMascotasFavoritasAMainActivity;
import ActivityMain.Main_Activity;
import ActivityMain.TodasLasMascotasDescripciones;
import ActivityMain.TodasLasMascotasRecyclerView;
import ActivityMain.adaptador_Mascotas;

public class MascotasFavoritas extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);

        ImageButton regresarDesdeMacotasFavoritas = (ImageButton) findViewById(R.id.regresarDesdeMascotasFavoritas);

        regresarDesdeMacotasFavoritas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });





        ArrayList <Mascota> mascotasFavoritas = new ArrayList<Mascota>();


        ArrayList <Mascota> mascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("MascotasFavoritas");

        for (Mascota favorita : mascotas){

            if(favorita.getTipoDeHuesolikes() == 1){

                mascotasFavoritas.add(favorita);

            }

        }



        RecyclerView MascotasTotales = (RecyclerView) findViewById(R.id.mascotasFavoritasRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((this));
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MascotasTotales.setLayoutManager(linearLayoutManager);
        adaptador_Mascotas_Favoritas adaptador_mascotas = new adaptador_Mascotas_Favoritas(mascotasFavoritas);
        MascotasTotales.setAdapter(adaptador_mascotas);

    }

    public static class adaptador_Mascotas_Favoritas extends RecyclerView.Adapter <adaptador_Mascotas_Favoritas.MascotaViewHolder> {


        private ArrayList <Mascota> mascotas;


        public adaptador_Mascotas_Favoritas (ArrayList<Mascota> mascotas){

            this.mascotas = mascotas;
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
                    Toast.makeText(view.getContext(), "Has eliminado a " + mascota1.getNombreDelCachorro() + " de tus favoritos.", Toast.LENGTH_SHORT).show();
                    mascotas.remove(position);
                    notifyDataSetChanged();
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



    }


}
