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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import ado.edu.itla.sosapp.entidad.Area;
import ado.edu.itla.sosapp.entidad.Solicitud;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.SessionManager;
import ado.edu.itla.sosapp.repositorio.area.AreaRepositorioImpl;
import ado.edu.itla.sosapp.repositorio.solicitud.SolicitudRepositorio;
import ado.edu.itla.sosapp.repositorio.solicitud.SolicitudRepositorioImpl;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioImpl;

public class SolicitudActivity extends AppCompatActivity {

    private  static String TAG = "REGISTRO_ SOLICITUD";
    SolicitudRepositorio solicitudRepositorio;
    UsuarioRepositorio usuarioRepositorio;
    AreaRepositorioImpl areaRepositorio;


    private Spinner spinerAreaSolicitud;
    private EditText titulo;
    private  EditText descripcion;
    private String estado;


    // Obtener fecha actual.
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    Date date = new Date();
    String fecha = dateFormat.format(date);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud);

        solicitudRepositorio = new SolicitudRepositorioImpl( this);
        usuarioRepositorio = new UsuarioRepositorioImpl(this);
        areaRepositorio = new AreaRepositorioImpl(this);

        final Usuario usuario = new Usuario();

        titulo = (EditText) findViewById(R.id.txttitulo_solicitud);
        descripcion = (EditText) findViewById(R.id.txtdescripcion_solicitud);
        spinerAreaSolicitud = (Spinner) findViewById(R.id.spinner_area_solicitud);

        //Lista de areas a fines en el Spinner

        final ArrayList<Area> adaptador = areaRepositorio.buscartodas();
        spinerAreaSolicitud.setAdapter(new ArrayAdapter<Area>(this,R.layout.spinner_item_area,adaptador));

        //Botón registrar solicitud.
        Button btnresigistrar_soli = findViewById(R.id.btnregistrar_solicitud);
        btnresigistrar_soli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Validar que los campos estén llenos.
                    if (titulo.getText().toString().length() == 0 || descripcion.getText().toString().length() == 0) {
                    Toast.makeText(SolicitudActivity.this, "Existen campos en blanco.", Toast.LENGTH_SHORT).show();
                    return;}

                    String seleccion = spinerAreaSolicitud.getSelectedItem().toString();
                    if (seleccion.equals("Selecione el área...")){
                        Toast.makeText(SolicitudActivity.this, "Debe selecionar una de las áreas.", Toast.LENGTH_SHORT).show();
                    return;}

                    SessionManager sessionManager = new SessionManager(v.getContext());
                    String user_email= sessionManager.get("idlogin");
                    Usuario usuario_solicitante=usuarioRepositorio.buscar(user_email);

                    Solicitud solicitud = new Solicitud();

                    solicitud.setFecha(fecha);
                    solicitud.setTitulo(titulo.getText().toString());
                    solicitud.setDescripcion(descripcion.getText().toString());
                    solicitud.setEstado("Pendiente");
                    Area area= (Area) spinerAreaSolicitud.getSelectedItem();
                    solicitud.setArea(area.getId());
                   solicitud.setUsuarioSolicitante(usuario_solicitante);

                   Toast.makeText(getApplicationContext(), "SolicitudActivity registrada con éxito.\nTítulo:" + solicitud.getTitulo(),
                    Toast.LENGTH_SHORT).show();


                //Log.i(TAG, solicitud.toString());
                    solicitudRepositorio.guardar(solicitud);
                    Log.i("PRUEBA", solicitud.toString());

                    titulo.setText("");
                    descripcion.setText("");
                    spinerAreaSolicitud.setSelection(0);

                    titulo.requestFocus();

            }

        });

    }

    //Cancelar el solicitud

    public void Inio (View view){
        Intent i=new Intent(this, Inicio.class);
        startActivity(i);
    }
}
