package ado.edu.itla.sosapp;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.sosapp.entidad.Area;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.SessionManager;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioImpl;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SOSAPP.MAINACTIVITY";
    UsuarioRepositorio usuarioRepositorio;

    //Creando variables locales.
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Entrando al Main Activity");
        Log.e(TAG, "Entrando al Main Activity");
        Log.i(TAG, "Entrando al Main Activity");

        usuarioRepositorio = new UsuarioRepositorioImpl(this);

        email= (EditText) findViewById(R.id.TxtUsuario_login);
        password= (EditText) findViewById(R.id.TxtContraseña_login);

        Button btnlogin = findViewById(R.id.BtnIniciar_login);
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (email.getText().toString().length() == 0) {
                        Toast.makeText(MainActivity.this, "Debe ingresar un usuario.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (password.getText().toString().length() == 0) {
                        Toast.makeText(MainActivity.this, "Debe ingresar una contraseña.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Usuario usuario =  usuarioRepositorio.buscar(email.getText().toString().trim());
                    if(usuario !=null && usuario.getPassword().equals(password.getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "Usuario\nNombre: " + usuario.getNombre(),
                            Toast.LENGTH_SHORT).show();

                        SessionManager sessionManager = new SessionManager(v.getContext());

                        sessionManager.set("idlogin", String.valueOf(usuario.getEmail()));
                        // Pasando la Activity de incio, luego de logueado
                        Intent i=new Intent(MainActivity.this, Inicio.class);
                        startActivity(i);

                    }else {

                        Toast.makeText(getApplicationContext(), "Usuario o Contraseña incorrectos",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });




//        Button btnBotton = (Button) findViewById(R.id.button);
//
//        btnBotton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Usuario usuario = new Usuario();
//
//                try {
//                    usuario.setEdad(-12);
//                }catch (Exception e) {
//                    Toast.makeText(MainActivity.this, "Edad o permtidad.", Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//                }
//
//            }
//        });

//        Usuario usuario1 = new Usuario();
//        usuario1.setNombre("Juan");
//        usuario1.setEmail("juan@gmail.com");
//        usuario1.setUserName("J1");
//        usuario1.setPassword("1");
//
//
//        List<Usuario> usuarioList=new ArrayList<>();
//        usuarioList.add(usuario1);
//
//        Log.i(TAG, "Tamaño de la lista:"+usuarioList.size());
//
//        for (Usuario u: usuarioList) {
//            Log.i (TAG, "Nombre:"+ u.getNombre());
//        }

    }


    // Llamar la activity registro

    public void registro (View view){
        Intent i=new Intent(this, Registro.class);
        startActivity(i);
    }

}
