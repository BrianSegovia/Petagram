package BASE_DE_DATOS;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mascotasrecyclerviewyactionview.Mascota;

import java.util.ArrayList;

public class BaseDeDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDeDatos(Context context) {
        super(context, ConstantesBaseDeDatos.DATABASE_NAME, null, ConstantesBaseDeDatos.DATA_BASE_VERSION);

        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDeDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_CANTIDAD_DE_LIKES + " TEXT, " +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_TIPO_DE_HUESO_LIKES + " INTERGER, " +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";


        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBaseDeDatos.TABLE__LIKE_MASCOTAS+ "(" +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_LIKES_ID_MASCOTA + "INTERGER," +
                ConstantesBaseDeDatos.TABLE_MASCOTAS_LIKES_CANTIDAD_DE_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDeDatos.TABLE_MASCOTAS_LIKES_ID_MASCOTA + ") " +
                "REFERENCES " +ConstantesBaseDeDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDeDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

        sqLiteDatabase.execSQL(queryCrearTablaMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDeDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDeDatos.TABLE__LIKE_MASCOTAS);
        onCreate(db);

    }

    

    public ArrayList<Mascota> obtenerTodasLasMascotas() {

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String query = "SELECT * FROM " + ConstantesBaseDeDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombreDelCachorro(registros.getString(1));
            mascotaActual.setCantidadDeLikes(registros.getString(2));
            mascotaActual.setTipoDeHuesolikes(registros.getInt(3));
            mascotaActual.setFotoCachorro(registros.getInt(4));


            mascotas.add(mascotaActual);
        }
    db.close();
        return mascotas;
    }






    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDeDatos.TABLE_MASCOTAS,null, contentValues);
        db.close();
    }








}