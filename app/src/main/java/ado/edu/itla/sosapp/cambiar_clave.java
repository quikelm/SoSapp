package ado.edu.itla.sosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.SessionManager;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;

public class cambiar_clave extends AppCompatActivity {
    UsuarioRepositorio usuarioRepositorio;

    EditText claveActual, claveNueva, claveNuevaConfirmar;
    TextView usuario_actual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_clave);

        claveActual  = (EditText) findViewById(R.id.txtclaveactual);
        claveNueva  = (EditText) findViewById(R.id.txtclavenueva);
        claveNuevaConfirmar = (EditText) findViewById(R.id.txtclavenuevaconfirmar);
        //usuario_actual = (TextView) findViewById(R.id.txtusuarioactuallabel);

//        SessionManager sessionManager = new SessionManager(this);
//        String user_email= sessionManager.get("idlogin");
//        final Usuario usuario_camb=usuarioRepositorio.buscar(user_email);


        //usuario_actual.setText(usuario_cambio.getNombre());

        Button cambiarClave = findViewById(R.id.btncambiarclave);
        cambiarClave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (claveActual.getText().toString().length() == 0){
                    Toast.makeText(cambiar_clave.this, "Debe ingresar la contraseña actual.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (claveNueva.getText().toString().length() == 0) {
                    Toast.makeText(cambiar_clave.this, "Debe ingresar la contraseña nueva.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (claveNuevaConfirmar.getText().toString().length() == 0) {
                    Toast.makeText(cambiar_clave.this, "Debe confirmar la contraseña.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (claveNueva.getText().toString().equals(claveNuevaConfirmar.getText().toString())) {

                    //Aqui actualizamos la contraseña.

                }else{

                    Toast.makeText(cambiar_clave.this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
                    return;
                }


//
//                Usuario usuario =  usuarioRepositorio.buscar(usuario_camb.getEmail());
//                if(usuario !=null && usuario.getPassword().equals(claveNueva.getText().toString().trim())){
//
//                    Toast.makeText(cambiar_clave.this, "Vamos bien", Toast.LENGTH_SHORT).show();
//                    return;
//
//                }else{
//                    Toast.makeText(cambiar_clave.this, "La contraseña actual no es correcta.", Toast.LENGTH_SHORT).show();
//                    return;
//                }





            }
        });


        Button cancelarCambio = findViewById(R.id.btncancelarcambio);
        cancelarCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(cambiar_clave.this, activity_configuracion.class);
                startActivity(i);
            }
        });

    }
}
