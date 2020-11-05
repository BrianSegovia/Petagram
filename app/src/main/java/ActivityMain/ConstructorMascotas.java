package ActivityMain;

import android.content.ContentValues;
import android.content.Context;

import com.example.mascotasrecyclerviewyactionview.Mascota;
import com.example.mascotasrecyclerviewyactionview.R;

import java.util.ArrayList;

import BASE_DE_DATOS.BaseDeDatos;
import BASE_DE_DATOS.ConstantesBaseDeDatos;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;


    public ConstructorMascotas (Context context) {this.context = context;}

    public ArrayList <Mascota> obtenerDatos(){

        BaseDeDatos db = new BaseDeDatos(context);
        insertarTresContactos(db);

        return db.obtenerTodasLasMascotas();


    }


    public void insertarTresContactos(BaseDeDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_NOMBRE, "\uD835\uDCE3\uD835\uDCF8\uD835\uDCFB\uD835\uDCEB\uD835\uDCEE\uD835\uDCF5\uD835\uDCF5\uD835\uDCF2\uD835\uDCF7\uD835\uDCF8");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_CANTIDAD_DE_LIKES, "0");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_TIPO_DE_HUESO_LIKES, R.drawable.icons8_dog_bone_401);
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_FOTO, R.drawable.cachorro_3);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_NOMBRE, "\uD835\uDCE3\uD835\uDCF8\uD835\uDCFB\uD835\uDCEB\uD835\uDCEE\uD835\uDCF5\uD835\uDCF5\uD835\uDCF2\uD835\uDCF7\uD835\uDCF8");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_CANTIDAD_DE_LIKES, "0");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_TIPO_DE_HUESO_LIKES, R.drawable.icons8_dog_bone_401);
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_FOTO, R.drawable.cachorro_2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_NOMBRE, "\uD835\uDCE3\uD835\uDCF8\uD835\uDCFB\uD835\uDCEB\uD835\uDCEE\uD835\uDCF5\uD835\uDCF5\uD835\uDCF2\uD835\uDCF7\uD835\uDCF8");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_CANTIDAD_DE_LIKES, "0");
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_TIPO_DE_HUESO_LIKES, R.drawable.icons8_dog_bone_401);
        contentValues.put(ConstantesBaseDeDatos.TABLE_MASCOTAS_FOTO, R.drawable.cachorro_1);

        db.insertarMascota(contentValues);
    }





}
