package ado.edu.itla.sosapp;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.sosapp.entidad.Usuario;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SOSAPP.MAINACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Entrando al Main Activity");
        Log.e(TAG, "Entrando al Main Activity");
        Log.i(TAG, "Entrando al Main Activity");

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

        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Juan");
        usuario1.setEmail("juan@gmail.com");
        usuario1.setUserName("J1");
        usuario1.setPassword("1");


        List<Usuario> usuarioList=new ArrayList<>();
        usuarioList.add(usuario1);

        Log.i(TAG, "Tamaño de la lista:"+usuarioList.size());

        for (Usuario u: usuarioList) {
            Log.i (TAG, "Nombre:"+ u.getNombre());
        }

    }
    // Llamar la activity registro

    public void Registro (View view){
        Intent i=new Intent(this, Registro.class);
        startActivity(i);
    }

}
