package ado.edu.itla.sosapp.repositorio.configuracion;

import ado.edu.itla.sosapp.entidad.Configuracion;

public interface ConfiguracionRepositorio {


   void  guardar (Configuracion configuracion);

   Configuracion buscar (int id);
}
