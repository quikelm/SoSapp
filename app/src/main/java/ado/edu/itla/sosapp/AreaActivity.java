package ado.edu.itla.sosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ado.edu.itla.sosapp.entidad.Area;
import ado.edu.itla.sosapp.repositorio.area.AreaRepositorio;
import ado.edu.itla.sosapp.repositorio.area.AreaRepositorioImpl;

public class AreaActivity extends AppCompatActivity {

    private static String TAG = "REGISTRO_AREA";
    Area area;
    AreaRepositorioImpl areaRepositorio;

    private EditText nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        areaRepositorio = new AreaRepositorioImpl(this);

        nombre = (EditText) findViewById(R.id.txtnombre_area);


        Button btncancelararea = findViewById(R.id.btncancelar_area);
        btncancelararea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(AreaActivity.this, activity_configuracion.class);
                startActivity(i);

            }
        });



        Button btnlogin = findViewById(R.id.btnregistrar_area);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Validar que los campos estén llenos.
                if (nombre.getText().toString().length() == 0) {
                    Toast.makeText(AreaActivity.this, "Existen campos en blanco.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Area area = new Area();

                area.setNombre(nombre.getText().toString());

                Log.i(TAG, area.toString());
                areaRepositorio.guardar(area);
                Log.i("PRUEBA", area.toString());

                nombre.setText("");

                Intent i=new Intent(AreaActivity.this, activity_configuracion.class);
                startActivity(i);
            }
        });

    }
}
