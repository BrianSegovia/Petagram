package ActivityMain;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mascotasrecyclerviewyactionview.AcercaDe;
import com.example.mascotasrecyclerviewyactionview.Contacto;
import com.example.mascotasrecyclerviewyactionview.Mascota;
import com.example.mascotasrecyclerviewyactionview.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

import MascotasFavoritas.MascotasFavoritas;

public class Main_Activity extends AppCompatActivity implements Comunicador {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Fragment todasLasMascotasRecyclerView = new TodasLasMascotasRecyclerView();
    private Fragment todasLasMascotasDescripciones = new TodasLasMascotasDescripciones();
    DeActivityAFragment deActivityAFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ImageButton estrellita = (ImageButton) findViewById(R.id.estrellita);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        Toolbar myToolBar = (Toolbar) findViewById(R.id.actionBar);


        //incializar Action Bar
        setSupportActionBar(myToolBar);
        getSupportActionBar().setTitle("");

        //Agregar los fragments
        setUpViewPager();

        estrellita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deActivityAFragment.EstrellaPresionada();

            }
        });



        //Fin del onCreate

    }

    @Override
    public void enviarLista(ArrayList<Mascota> mascotas) {
        Intent intent = new Intent(Main_Activity.this, MascotasFavoritas.class);
        intent.putExtra("MascotasFavoritas", mascotas);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tres_puntitos, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.Contacto){
            Intent intent = new Intent(Main_Activity.this, Contacto.class);
            startActivity(intent);
        }

        if (id == R.id.AcercaDe){
            Intent intent = new Intent(Main_Activity.this, AcercaDe.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }


    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(todasLasMascotasRecyclerView);
        fragments.add(todasLasMascotasDescripciones);

        return fragments;
    }


    private void setUpViewPager() {
        viewPager.setAdapter(new Adaptador_ViewPager_Main_Activity(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Todas las mascotas");
        tabLayout.getTabAt(1).setText("Perfil");

    }


    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {

        Fragment fragment1 = fragment;

        if(fragment == todasLasMascotasRecyclerView){

            deActivityAFragment = (DeActivityAFragment) fragment1;
        }

        super.onAttachFragment(fragment);
    }

    @Override
    protected void onResume() {
        Bundle parametros = getIntent().getExtras();
        if(parametros !=null){
            String nombreDelPerritoEliminado = parametros.getString("nombre");
            deActivityAFragment.perritoEliminado(nombreDelPerritoEliminado);
            Toast.makeText(getApplicationContext(), "Si entra", Toast.LENGTH_SHORT).show();
        }
        super.onResume();
    }
}






