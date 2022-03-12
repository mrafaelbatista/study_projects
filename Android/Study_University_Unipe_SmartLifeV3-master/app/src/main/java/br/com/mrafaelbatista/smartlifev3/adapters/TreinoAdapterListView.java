package br.com.mrafaelbatista.smartlifev3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.mrafaelbatista.smartlifev3.R;
import br.com.mrafaelbatista.smartlifev3.models.Treino;

/**
 * Created by mrafa on 26/10/2015.
 */
public class TreinoAdapterListView extends ArrayAdapter<Treino> {

    private ArrayList<Treino> treinos;
    private LayoutInflater inflater;
    private Context context;

    public TreinoAdapterListView(Context context, int resource, ArrayList<Treino> treinos) {
        super(context, resource, treinos);

        this.context = context;
        this.treinos = treinos;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     //   return super.getView(position, convertView, parent);

        Treino t = treinos.get(position);

        TreinoHolder holder;
        TextView tv_nomeTreino;
        TextView tv_objTreino;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.itemlist_treino, null);

            tv_nomeTreino = (TextView) convertView.findViewById(R.id.tv_lv_nomeTreino);
            tv_objTreino = (TextView) convertView.findViewById(R.id.tv_lv_objTreino);

            holder = new TreinoHolder();
            holder.tv_adapter_nomeTreino = tv_nomeTreino;
            holder.tv_adapter_objTreino = tv_objTreino;

            convertView.setTag(holder);
        } else {
            holder = (TreinoHolder) convertView.getTag();
            tv_nomeTreino = holder.tv_adapter_nomeTreino;
            tv_objTreino = holder.tv_adapter_objTreino;
        }

        tv_nomeTreino.setText("Treino: " + t.getNomeTreino());
        tv_objTreino.setText("Objetivo: " + t.getObjetivoTreino());

        return convertView;
    }

    private class TreinoHolder {
        public TextView tv_adapter_nomeTreino;
        public TextView tv_adapter_objTreino;
        //Falta adicionar atividades;
    }
}
