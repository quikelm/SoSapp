package ado.edu.itla.sosapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ado.edu.itla.sosapp.entidad.Solicitud;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;
import ado.edu.itla.sosapp.repositorio.SessionManager;
import ado.edu.itla.sosapp.repositorio.SolicitudAdapter;
import ado.edu.itla.sosapp.repositorio.solicitud.SolicitudRepositorio;
import ado.edu.itla.sosapp.repositorio.solicitud.SolicitudRepositorioImpl;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;

public class Inicio extends AppCompatActivity {

    SolicitudRepositorio solicitudRepositorio;
    DbConexion dbConexion;
    SolicitudAdapter solicitudAdapter;
    UsuarioRepositorio usuarioRepositorio;



  //  public Inicio (Context context) {this.dbConexion = new DbConexion(context);}

    //private int id=1;
    private ListView lv;
    private ArrayList <Solicitud> solicitudes = new ArrayList<>();


   // private String solic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Solicitud solicitud = new Solicitud();


        //solicitudes = new ArrayList<Solicitud>();
         lv = (ListView) findViewById(R.id.lv_solicitudes);
         solicitudes.add(new Solicitud());


//
        //ArrayList<Solicitud> adapter = new SolicitudAdapter(this, solicitudes);
        //lv.setAdapter(adapter);


        Button btnmisSolicitudes = findViewById(R.id.btn_missoli_inicio);
        btnmisSolicitudes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                SessionManager sessionManager = new SessionManager(v.getContext());
//                String user_email= sessionManager.get("idlogin");
//                final Usuario usuario_solicitante=usuarioRepositorio.buscar(user_email);



            }
        });


    }


    public void solicitud (View view){
        Intent i=new Intent(this, SolicitudActivity.class);
        startActivity(i); }


    public void configuracion (View view){
        Intent i=new Intent(this, activity_configuracion.class);
        startActivity(i); }

}
