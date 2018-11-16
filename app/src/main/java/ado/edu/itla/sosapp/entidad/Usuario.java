package ado.edu.itla.sosapp.entidad;

public class Usuario {

    public int id;
    private int edad;
    private String nombre;
    private String userName;
    private String Password;
    private String email;

    // poniendok todos lose Set
    public void setEdad(int edad) throws Exception {

        if (edad < 0 || edad > 130) {
            throw new RuntimeException("Erro: Edad no permitida.");
        }
        this.edad = edad;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return email;
    }
}

