package ado.edu.itla.sosapp.repositorio.solicitud;

import java.util.ArrayList;

import ado.edu.itla.sosapp.entidad.Solicitud;

public interface SolicitudRepositorio {

    void guardar (Solicitud solicitud);

     ArrayList <Solicitud> buscarSolicitudes (int usuario);
}
