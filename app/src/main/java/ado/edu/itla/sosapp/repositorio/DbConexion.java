package ado.edu.itla.sosapp.repositorio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import ado.edu.itla.sosapp.entidad.Usuario;

public class DbConexion extends SQLiteOpenHelper {

    private static String NOMBRE_BASEDATOS = "sosapp_db.db";
    private static int VERSION_BASEDATOS = 1;

    //Creando la base de datos.

    // Tabla usuario.
    private static String TABLA_USUARIO = "CREATE TABLE `usuario` (" +
            "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
	        "`email` TEXT NOT NULL," +
            "`nombre` TEXT NOT NULL," +
            "`password` TEXT NOT NULL" +
            ")";

    // Tabla solicitud
    private static String TABLA_SOLICITUD = "CREATE TABLE `solicitud` (" +
            "`id`	INTEGER PRIMARY KEY AUTOINCREMENT," +
            "`fecha`	TEXT NOT NULL," +
	        "`titulo`	TEXT NOT NULL," +
            "`descripcion`	TEXT NOT NULL," +
            "`estado`	TEXT NOT NULL," +
            "`area`	INTEGER NOT NULL," +
            "`usuario_solicitante_id`	INTEGER NOT NULL," +
            "`usuario_asignado_id`	INTEGER," +
            "FOREIGN KEY(usuario_solicitante_id) REFERENCES usuario(id)," +
            "FOREIGN KEY(usuario_asignado_id) REFERENCES usuario(id)" +
            ")";

    // Tabla area
    private static String TABLA_AREA = "CREATE TABLE `area` (" +
            "`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
	        "`nombre`	TEXT NOT NULL" +
            ")";

    // Tabla detalle_area
    private static String TABLA_DETALLE_AREA = "CREATE TABLE `detalle_area` (" +
            "`area_id`	INTEGER NOT NULL," +
            "`usuario_id`	INTEGER NOT NULL," +
            "FOREIGN KEY(area_id) REFERENCES area(id)," +
            "FOREIGN KEY(usuario_id) REFERENCES usuario(id)" +
            ")";

    public DbConexion(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLA_USUARIO);
        db.execSQL(TABLA_SOLICITUD);
        db.execSQL(TABLA_AREA);
        db.execSQL(TABLA_DETALLE_AREA);

        db.execSQL("INSERT INTO area(nombre) VALUES('Electronica');");
        db.execSQL("INSERT INTO area(nombre) VALUES('Informatica');");
        db.execSQL("INSERT INTO area(nombre) VALUES('Refrigeracion');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
