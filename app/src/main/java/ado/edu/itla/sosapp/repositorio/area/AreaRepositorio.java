package ado.edu.itla.sosapp.repositorio.area;

import java.util.ArrayList;

import ado.edu.itla.sosapp.entidad.Area;

public interface AreaRepositorio {

    void guardar (Area area);

    Area buscar (int id);

    ArrayList <Area> buscartodas ();
}
