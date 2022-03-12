package br.com.mrafaelbatista.smartlifev3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
import br.com.mrafaelbatista.smartlifev3.auxiliar.Constants;
import br.com.mrafaelbatista.smartlifev3.models.Treino;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    private ListView lv;
    private TreinoAdapterListView adapter;
    private ArrayList<Treino> alistTreinos;
    private TextView tv_Semtreinos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    protected void onResume() {
        super.onResume();

        //Adapter para LisView
        //StringBuffer result = new StringBuffer();
        alistTreinos = new ArrayList<Treino>();
        alistTreinos = (ArrayList<Treino>) Treino.listAll(Treino.class);

        /*lv = (ListView) findViewById(R.id.lv_Treinos);
        adapter = new TreinoAdapterListView(this, R.layout.itemlist_treino, alistTreinos);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);*/

        if (!(alistTreinos.isEmpty())) {
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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mdw_cadTreino) {
            Intent i = new Intent(Main2Activity.this, CadastroTreino.class);
            startActivity(i);
        } else if (id == R.id.mdw_listAlimentos) {
            Intent i = new Intent(Main2Activity.this, DietaActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Treino t = adapter.getItem(position);

        Toast.makeText(Main2Activity.this, t.getNomeTreino() + " : " + t.getObjetivoTreino(), Toast.LENGTH_SHORT).show();
    }
}
