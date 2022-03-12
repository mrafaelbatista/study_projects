package br.com.mrafaelbatista.smartlifev3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.mrafaelbatista.smartlifev3.R;
import br.com.mrafaelbatista.smartlifev3.models.Dieta;


/**
 * Created by mrafa on 26/10/2015.
 */
public class DietaAdapterListView extends ArrayAdapter<Dieta> {

    private ArrayList<Dieta> dietas;
    private LayoutInflater inflater;
    private Context context;

    public DietaAdapterListView(Context context, int resource, ArrayList<Dieta> dietas) {
        super(context, resource, dietas);

        this.context = context;
        this.dietas = dietas;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     //   return super.getView(position, convertView, parent);

        Dieta t = dietas.get(position);

        DietaHolder holder;
        TextView tv_nomeDieta;
        TextView tv_cafeDieta;
        TextView tv_almocoDieta;
        TextView tv_jantarDieta;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.itemlist_dieta, null);

            tv_nomeDieta = (TextView) convertView.findViewById(R.id.tv_nomeDieta);
            tv_cafeDieta = (TextView) convertView.findViewById(R.id.tv_cafeDieta);
            tv_almocoDieta = (TextView) convertView.findViewById(R.id.tv_almocoDieta);
            tv_jantarDieta = (TextView) convertView.findViewById(R.id.tv_jantarDieta);

            holder = new DietaHolder();
            holder.tv_adapter_nomeDieta = tv_nomeDieta;
            holder.tv_adapter_cafeDieta = tv_cafeDieta;
            holder.tv_adapter_almocoDieta = tv_almocoDieta;
            holder.tv_adapter_jantarDieta = tv_jantarDieta;

            convertView.setTag(holder);
        } else {
            holder = (DietaHolder) convertView.getTag();
            tv_nomeDieta = holder.tv_adapter_nomeDieta;
            tv_cafeDieta = holder.tv_adapter_cafeDieta;
            tv_almocoDieta = holder.tv_adapter_almocoDieta;
            tv_jantarDieta = holder.tv_adapter_jantarDieta;
        }

        tv_nomeDieta.setText("Dieta: " + t.getNome());
        tv_cafeDieta.setText("Café: " + t.getCafe_da_manha());
        tv_almocoDieta.setText("Almoço: " + t.getAlmoco());
        tv_jantarDieta.setText("Jantar: " + t.getJantar());

        return convertView;
    }

    private class DietaHolder {
        public TextView tv_adapter_nomeDieta;
        public TextView tv_adapter_cafeDieta;
        public TextView tv_adapter_almocoDieta;
        public TextView tv_adapter_jantarDieta;
        //Falta adicionar atividades;
    }
}
