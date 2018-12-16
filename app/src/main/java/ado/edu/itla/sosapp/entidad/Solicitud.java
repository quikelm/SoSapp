package ado.edu.itla.sosapp.entidad;

public class Solicitud {

    public int id;
    private String fecha;
    private String titulo;
    private String descripcion;
    private String estado;
    private int area;
    public Usuario usuarioSolicitante;
    public Usuario usuarioAsignado;

    // Get.

    public int getId() { return id; }

    public String getFecha() { return fecha; }

    public String getTitulo() { return titulo; }

    public String getDescripcion() { return descripcion; }

    public String getEstado() { return estado; }

    public int getArea() { return area; }

    public Usuario getUsuarioSolicitante() { return usuarioSolicitante; }

    public Usuario getUsuarioAsignado() { return usuarioAsignado; }

//Set.

    public void setId(int id) { this.id = id; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setEstado(String estado) { this.estado = estado; }

    public void setArea(int area) { this.area = area; }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) { this.usuarioSolicitante = usuarioSolicitante; }

    public void setUsuarioAsignado(Usuario usuarioAsignado) { this.usuarioAsignado = usuarioAsignado; }



    // ToString


    @Override
    public String toString() {
        return "Solicitud{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", area='" + area + '\'' +
                ", usuarioSolicitante=" + usuarioSolicitante +
                ", usuarioAsignado=" + usuarioAsignado +
                '}';
    }
}

