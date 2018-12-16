package ado.edu.itla.sosapp.repositorio.configuracion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import ado.edu.itla.sosapp.entidad.Configuracion;
import ado.edu.itla.sosapp.repositorio.DbConexion;

public class ConfiguracionRepositorioImpl implements ConfiguracionRepositorio {

    private DbConexion dbConexion;

    public ConfiguracionRepositorioImpl (Context context){

        this.dbConexion = new DbConexion(context);
    }


    public void guardar(Configuracion configuracion) {

        ContentValues cv = new ContentValues();
        cv.put("usuario_id", configuracion.getUsuario_id());
        cv.put("area_id", configuracion.getArea_id());

        SQLiteDatabase db= dbConexion.getWritableDatabase();

        db.insert("detalle_area", null, cv);
        //configuracion.setArea_id(id.intValue());
    }

    @Override
    public Configuracion buscar(int id) {
        return null;
    }
}
