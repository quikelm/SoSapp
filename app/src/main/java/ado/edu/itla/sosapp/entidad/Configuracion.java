package ado.edu.itla.sosapp.entidad;

public class Configuracion {

    public int usuario_id;
    public int area_id;


    //Setter


    public void setUsuario_id(int usuario_id) { this.usuario_id = usuario_id; }

    public void setArea_id(int area_id) { this.area_id = area_id; }


    //Getter

    public int getUsuario_id() { return usuario_id; }

    public int getArea_id() { return area_id; }

    @Override
    public String toString() {
        return "Configuracion{" +
                "usuario_id=" + usuario_id +
                ", area_id=" + area_id +
                '}';
    }
}
