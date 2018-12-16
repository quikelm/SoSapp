package ado.edu.itla.sosapp.repositorio.solicitud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ado.edu.itla.sosapp.entidad.Solicitud;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;

public class SolicitudRepositorioImpl implements SolicitudRepositorio {

    private Usuario usuario;
    private DbConexion dbConexion;



    public SolicitudRepositorioImpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void guardar(Solicitud solicitud) {
        ContentValues cv = new ContentValues();
        cv.put("titulo", solicitud.getTitulo());
        cv.put("descripcion", solicitud.getDescripcion());
        cv.put("estado", solicitud.getEstado());
        cv.put("area", solicitud.getArea());
        cv.put("usuario_solicitante_id", solicitud.getUsuarioSolicitante().getId());
        cv.put("fecha", solicitud.getFecha());
       // cv.put("usuario_asignado_id", 0);

        SQLiteDatabase db = dbConexion.getWritableDatabase();

        Long id = db.insert("solicitud", null, cv);
        solicitud.setId(id.intValue());

    }


    @Override
    public ArrayList<Solicitud> buscarSolicitudes(int usuario) {


        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.query("solicicitud", null, "usuario_solicitante_id=?", new String[]{String.valueOf(usuario)}, null, null, null, null );
        Solicitud solicitud = null;
        ArrayList<Solicitud> solicitudArrayList = new ArrayList<>();

        while (cursor.moveToNext()){
            solicitud = new Solicitud();
            //solicitud.setId(cursor.getInt(cursor.getColumnIndex("id")));
            solicitud.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            //solicitud.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            //solicitud.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            //solicitud.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
            //solicitud.setArea(cursor.getInt(cursor.getColumnIndex("area")));
            solicitudArrayList.add(solicitud);

        }
        cursor.close();

        db.close();
        return solicitudArrayList;

    }


}