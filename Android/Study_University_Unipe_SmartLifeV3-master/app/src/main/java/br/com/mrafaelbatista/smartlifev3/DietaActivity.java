package br.com.mrafaelbatista.smartlifev3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.com.mrafaelbatista.smartlifev3.adapters.DietaAdapterListView;
import br.com.mrafaelbatista.smartlifev3.auxiliar.Constants;
import br.com.mrafaelbatista.smartlifev3.connection.volley.requests.DietaRequest;
import br.com.mrafaelbatista.smartlifev3.models.Dieta;

public class DietaActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener, AdapterView.OnItemClickListener {

    private TextView tv;
    private ListView lv;
    private DietaAdapterListView adapter;
    private ArrayList<Dieta> alDietas;

    private ProgressDialog pDialog;

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Progress Dialog
        pDialog = new ProgressDialog(DietaActivity.this);
        pDialog.setMessage("Conectando a internet...carregando...");
    }

    protected void onResume() {
        super.onResume();

        //Adapter para LisView
        //StringBuffer result = new StringBuffer();
        alDietas = new ArrayList<Dieta>();
        alDietas = (ArrayList<Dieta>) Dieta.listAll(Dieta.class);

        lv = (ListView) findViewById(R.id.lv_Dietas);
        adapter = new DietaAdapterListView(this, R.layout.itemlist_dieta, alDietas);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.mn2_sair) {
            //Antes de fechar limpar o Shared Preferences
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString(Constants.TOKEN, null);
            editor.putString(Constants.MANTER_CONECTADO, null);
            editor.commit();

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
            finish();
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        pDialog.dismiss();
        Toast.makeText(DietaActivity.this, "Você NÃO está CONECTADO!", Toast.LENGTH_LONG).show();
        Toast.makeText(DietaActivity.this, "Utilizando dados armazenados", Toast.LENGTH_LONG).show();

        alDietas = new ArrayList<>();
        alDietas = (ArrayList<Dieta>) Dieta.listAll(Dieta.class);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onResponse(Object response) {
        pDialog.dismiss();
        Toast.makeText(DietaActivity.this, "Funfou!!", Toast.LENGTH_LONG).show();

        List<Dieta> ld = Dieta.listAll(Dieta.class);
        for (Dieta d : ld) {
            d.delete();
        }

        pDialog.setMessage("Construindo a tela!");
        pDialog.show();
        Gson g = new Gson();
        Dieta[] d = g.fromJson(response.toString(), Dieta[].class);

        alDietas.clear();

        for (int i = 0; i < d.length; i++) {
            d[i].save();
            alDietas.add(d[i]);
        }
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        pDialog.dismiss();

    }

    public void dieta1(MenuItem item) {
        pDialog.show();

        url = "http://mrafaelbatista.com.br/android_json/dieta1.json";
        DietaRequest dietaRequest = new DietaRequest();
        dietaRequest.requestImageGet(DietaActivity.this, DietaActivity.this, url);

    }

    public void dieta2(MenuItem item) {
        pDialog.show();

        url = "http://mrafaelbatista.com.br/android_json/dieta2.json";
        DietaRequest dietaRequest = new DietaRequest();
        dietaRequest.requestImageGet(DietaActivity.this, DietaActivity.this, url);

    }

    public void dieta3(MenuItem item) {
        pDialog.show();

        url = "http://mrafaelbatista.com.br/android_json/dieta3.json";
        DietaRequest dietaRequest = new DietaRequest();
        dietaRequest.requestImageGet(DietaActivity.this, DietaActivity.this, url);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Dieta d = adapter.getItem(position);

    }
}
