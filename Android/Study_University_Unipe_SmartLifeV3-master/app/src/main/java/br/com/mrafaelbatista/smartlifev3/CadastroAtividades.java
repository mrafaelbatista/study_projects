package br.com.mrafaelbatista.smartlifev3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.mrafaelbatista.smartlifev3.Controllers.ControllerCadastroTreino;
import br.com.mrafaelbatista.smartlifev3.auxiliar.Constants;
import br.com.mrafaelbatista.smartlifev3.models.Atividade;

public class CadastroAtividades extends AppCompatActivity {

    private List<CheckBox> listCheckbox = new ArrayList<>();
    private ArrayList<Atividade> aList = new ArrayList<>();
    private Atividade atividade;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private CheckBox cb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_atividades);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Seboso, mas funfou!!!
        cb1 = (CheckBox) findViewById(R.id.cb_abdFrontal);
        listCheckbox.add(cb1);
        cb2 = (CheckBox) findViewById(R.id.cb_abdBike);
        listCheckbox.add(cb2);
        cb3 = (CheckBox) findViewById(R.id.cb_abdInversao);
        listCheckbox.add(cb3);
        cb4 = (CheckBox) findViewById(R.id.cb_bcpRoscaConcent);
        listCheckbox.add(cb4);
        cb5 = (CheckBox) findViewById(R.id.cb_bcpRoscaDireta);
        listCheckbox.add(cb5);
        cb6 = (CheckBox) findViewById(R.id.cb_bcpRoscaAlternada);
        listCheckbox.add(cb6);
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

    public void listarAtividades(View v) {

        for (CheckBox c : listCheckbox) {
            if (c.isChecked()) {
                atividade = new Atividade(c.getText().toString());
                aList.add(atividade);
            }
        }

        ControllerCadastroTreino.getInstance().setListaAtividades(aList);
        Intent i = new Intent(CadastroAtividades.this, CadastroTreino.class);
        startActivity(i);
        finish();
    }



}
