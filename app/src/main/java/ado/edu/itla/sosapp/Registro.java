package ado.edu.itla.sosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioImpl;

public class Registro extends AppCompatActivity {

    private static String TAG = "REGISTRO_USUARIO";
    UsuarioRepositorio usuarioRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuarioRepositorio = new UsuarioRepositorioImpl(this);

        final EditText emailText = findViewById(R.id.TxtEmail_registro);
        final EditText nombreText = findViewById(R.id.TxtNombre_registro);
        final EditText passwordText = findViewById(R.id.TxtContraseña_login);
        final EditText password2Text = findViewById(R.id.TxtRepetirContraseña_registro);

        Button btnRegistrarse = findViewById(R.id.registro_registrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (nombreText.getText().toString().length() == 0 || emailText.getText().toString().length() == 0 || passwordText.getText().toString().length() == 0 || password2Text.getText().toString().length() == 0) {

                    Toast.makeText(Registro.this, "Existen campos en blanco.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passwordText.getText().toString().equals(password2Text.getText().toString())){

                    Usuario usuario = new Usuario();
                    usuario.setNombre(nombreText.getText().toString());
                    usuario.setEmail(emailText.getText().toString());
                    usuario.setPassword(passwordText.getText().toString());

                    Log.i(TAG, usuario.toString());
                    usuarioRepositorio.guardar(usuario);
                    Log.i(TAG, usuario.toString());

                    nombreText.setText("");
                    emailText.setText("");
                    passwordText.setText("");
                    password2Text.setText("");

                    // Pasando la Activity de incio, luego de logueado
                    Intent i=new Intent(Registro.this, MainActivity.class);
                    startActivity(i);

                }else{

                    Toast.makeText(Registro.this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
                    return;

                }
            }
        });
    }

    //Cancelar el registro

    public void login (View view){
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
