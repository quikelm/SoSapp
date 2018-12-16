package ado.edu.itla.sosapp.entidad;

public class Usuario {

    public int id;
    private String nombre;
    private String Password;
    private String email;

    // poniendo todos lose Set

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//     Poniendo todos los get.

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Password='" + Password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

