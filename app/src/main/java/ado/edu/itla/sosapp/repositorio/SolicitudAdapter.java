package ado.edu.itla.sosapp.repositorio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import ado.edu.itla.sosapp.R;
import ado.edu.itla.sosapp.entidad.Solicitud;

public class SolicitudAdapter extends BaseAdapter {

    private SimpleDateFormat SDF;
    private Context context;
    private List<Solicitud> solicitudes;

    public SolicitudAdapter(Context context, int solicitud_list_item, List<Solicitud> solicitudes){
        this.context =  context;
        this.solicitudes = solicitudes;

    }

    @Override
    public int getCount() {
        return solicitudes.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View solicitudItem, ViewGroup parent) {

        if(solicitudItem == null)
            solicitudItem = LayoutInflater.from(context).inflate(R.layout.solicitud_list_item, null);

        TextView txtTitulo = solicitudItem.findViewById(R.id.solicitud_item_titulo);
        TextView txtFecha = solicitudItem.findViewById(R.id.solicitud_item_fecha);
        TextView txtUsuarioSolicitante = solicitudItem.findViewById(R.id.solicitud_item_usuario);

        Solicitud solicitud = solicitudes.get(position);

        txtTitulo.setText(solicitud.getTitulo());
        txtFecha.setText(SDF.format(solicitud.getFecha()));
        txtUsuarioSolicitante.setText(solicitud.usuarioSolicitante.getNombre());


        return solicitudItem;
    }
}
