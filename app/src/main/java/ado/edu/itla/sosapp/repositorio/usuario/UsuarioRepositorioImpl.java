package ado.edu.itla.sosapp.repositorio.usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;

public class UsuarioRepositorioImpl implements UsuarioRepositorio {

    private DbConexion dbConexion;

    public UsuarioRepositorioImpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void guardar(Usuario usuario) {

        ContentValues cv = new ContentValues();
        cv.put("email", usuario.getEmail());
        cv.put("nombre", usuario.getNombre());
        cv.put("password", usuario.getPassword());

        SQLiteDatabase db= dbConexion.getWritableDatabase();

        Long id = db.insert("usuario", null, cv);
        usuario.setId(id.intValue());
    }

    @Override
    public Usuario buscar(String email) {

        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.query("usuario", null, "email=?", new String[]{email}, null, null, null, null );
        Usuario usuario = null;
         if (cursor.moveToNext()){
             usuario = new Usuario();
             usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
             usuario.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
             usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));
             usuario.setPassword(cursor.getString(cursor.getColumnIndex("password")));
             cursor.close();
         }
         db.close();
        return usuario;
    }
}
