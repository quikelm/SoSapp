package ado.edu.itla.sosapp.repositorio.area;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ado.edu.itla.sosapp.entidad.Area;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;

public class AreaRepositorioImpl implements AreaRepositorio {

    private DbConexion dbConexion;

    public AreaRepositorioImpl (Context context) {
        this.dbConexion = new DbConexion(context);

    }

    @Override
    public void guardar(Area area) {

        ContentValues cv = new ContentValues();
        cv.put("nombre", area.getNombre());

        SQLiteDatabase db= dbConexion.getWritableDatabase();

        Long id = db.insert("area", null, cv);
        area.setId(id.intValue());
    }

    @Override
    public Area buscar(int id) {

        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.query("area", null, "id=?", new String[]{String.valueOf(id)}, null, null, null, null );
        Area area = null;
        if (cursor.moveToNext()){
             area= new Area();
            area.setId(cursor.getInt(cursor.getColumnIndex("id")));
            area.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
        }
        cursor.close();

        db.close();
        return area;
    }


    @Override
    public ArrayList<Area> buscartodas() {

        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.query("area", null, null, null, null, null, null, null );
        Area area = null;
        ArrayList<Area> areaArrayList = new ArrayList<>();
        while (cursor.moveToNext()){
            area= new Area();
            area.setId(cursor.getInt(cursor.getColumnIndex("id")));
            area.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            areaArrayList.add(area);
        }
        cursor.close();

        db.close();
        return areaArrayList;

    }
}
