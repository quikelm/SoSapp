package ado.edu.itla.sosapp.entidad;

import android.database.sqlite.SQLiteDatabase;

public class Area {

    public int id;
    private String nombre;

    public void setId(int id) { this.id = id; }

    public void setNombre(String nombre) { this.nombre = nombre; }


    public int getId() { return id; }

    public String getNombre() { return nombre; }


    @Override
    public String toString() {
        return nombre;

    }
}
