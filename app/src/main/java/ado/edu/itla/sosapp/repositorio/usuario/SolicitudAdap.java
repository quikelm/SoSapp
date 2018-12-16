package ado.edu.itla.sosapp.repositorio.usuario;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ado.edu.itla.sosapp.R;
import ado.edu.itla.sosapp.repositorio.Lista;

public class SolicitudAdap extends BaseAdapter {

    private ArrayList<Lista> solicitudes;
    private LayoutInflater layoutInflater;

    public SolicitudAdap(Context context, ArrayList<Lista> solicitudes) {
        this.solicitudes = solicitudes;
        layoutInflater = (LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return solicitudes.size();
    }

    @Override
    public Object getItem(int position) {
        return solicitudes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.solicitud_list_item, parent, false);

            TextView txtTitulo = (TextView) convertView.findViewById(R.id.solicitud_item_titulo);
            TextView txtUsuario = (TextView) convertView.findViewById(R.id.solicitud_item_usuario);
            TextView txtFecha = (TextView) convertView.findViewById(R.id.solicitud_item_fecha);


            Lista Lista = (Lista) getItem(position);
            txtUsuario.setText(Lista.usuarioSolicitante.getNombre());
            txtTitulo.setText(Lista.getTitulo());
            txtFecha.setText(Lista.getFecha());

        }
        return convertView;
    }



}
