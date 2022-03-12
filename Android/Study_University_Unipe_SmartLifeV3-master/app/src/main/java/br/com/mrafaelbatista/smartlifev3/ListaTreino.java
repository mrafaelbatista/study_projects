package br.com.mrafaelbatista.smartlifev3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.mrafaelbatista.smartlifev3.adapters.TreinoAdapterListView;
import br.com.mrafaelbatista.smartlifev3.models.Treino;

public class ListaTreino extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lv;
    private TreinoAdapterListView adapter;
    private ArrayList<Treino> alistTreinos;
    private TextView tv_Semtreinos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_treinos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StringBuffer result = new StringBuffer();
        alistTreinos = new ArrayList<Treino>();
        alistTreinos = (ArrayList<Treino>) Treino.listAll(Treino.class);

        if (alistTreinos.isEmpty()) {
            lv = (ListView) findViewById(R.id.lv_Treinos);
            adapter = new TreinoAdapterListView(this, R.layout.itemlist_treino, alistTreinos);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(this);
        } else {
            tv_Semtreinos = (TextView) findViewById(R.id.tv_ListaTreino);
            tv_Semtreinos.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.mn_sair) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Treino t = adapter.getItem(position);
        Toast.makeText(ListaTreino.this, t.getNomeTreino() + " : " + t.getObjetivoTreino(), Toast.LENGTH_SHORT).show();
    }
}
