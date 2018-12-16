package ado.edu.itla.sosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import ado.edu.itla.sosapp.entidad.Area;
import ado.edu.itla.sosapp.entidad.Configuracion;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.SessionManager;
import ado.edu.itla.sosapp.repositorio.area.AreaRepositorioImpl;
import ado.edu.itla.sosapp.repositorio.configuracion.ConfiguracionRepositorio;
import ado.edu.itla.sosapp.repositorio.configuracion.ConfiguracionRepositorioImpl;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioImpl;

public class activity_configuracion extends AppCompatActivity {

    AreaRepositorioImpl areaRepositorio;
    UsuarioRepositorio usuarioRepositorio;
    ConfiguracionRepositorioImpl configuracionRepositorio;

    private Spinner spinnerArea;
    private EditText nombreUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        areaRepositorio = new AreaRepositorioImpl(this);
        usuarioRepositorio = new UsuarioRepositorioImpl(this);
        configuracionRepositorio = new ConfiguracionRepositorioImpl(this);

        SessionManager sessionManager = new SessionManager(this);
        String user_email= sessionManager.get("idlogin");
        final Usuario usuario_configurado=usuarioRepositorio.buscar(user_email);

        spinnerArea = (Spinner) findViewById(R.id.spinnerAreaConfiguracion);
        nombreUsuario = (EditText) findViewById(R.id.txtusuario_configuracion);

        nombreUsuario.setText(usuario_configurado.getNombre());

        final ArrayList<Area> adaptador = areaRepositorio.buscartodas();
        spinnerArea.setAdapter(new ArrayAdapter<Area>(this,R.layout.spinner_item_area,adaptador));


        Button guardarConfiguracion = findViewById(R.id.btnguardar_configuracion);
        guardarConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Configuracion configuracion = new Configuracion();

                configuracion.setUsuario_id(usuario_configurado.getId());
                Area areaConf= (Area) spinnerArea.getSelectedItem();
                configuracion.setArea_id(areaConf.getId());

               configuracionRepositorio.guardar(configuracion);
                Log.i("PRUEBA", configuracion.toString());

            }
        });



    }


    public void cancelarConfigu (View view){
        Intent i=new Intent(this, Inicio.class);
        startActivity(i); }


    public void agregarArea (View view){
        Intent i=new Intent(this, AreaActivity.class);
        startActivity(i); }

    public void cambioClave (View view){
        Intent i=new Intent(this, cambiar_clave.class);
        startActivity(i); }

}
