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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.mrafaelbatista.smartlifev3.Controllers.ControllerCadastroTreino;
import br.com.mrafaelbatista.smartlifev3.auxiliar.Constants;
import br.com.mrafaelbatista.smartlifev3.models.Atividade;
import br.com.mrafaelbatista.smartlifev3.models.Treino;

public class CadastroTreino extends AppCompatActivity {

    private EditText nomeTreino;
    private EditText objTreino;
    private ArrayList<Atividade> atividades;
    private TextView listaAtividadesTreino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_treino);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nomeTreino = (EditText) findViewById(R.id.nomeTreino);
        objTreino = (EditText) findViewById(R.id.objTreino);

        atividades = new ArrayList<>();

        listaAtividadesTreino = (TextView) findViewById(R.id.listaAtividadesTreino);

    }

    protected void onResume() {
        super.onResume();

        String nTreino = ControllerCadastroTreino.getInstance().getNomeTreino();
        String oTreino = ControllerCadastroTreino.getInstance().getObjTreino();
        atividades = (ArrayList<Atividade>) ControllerCadastroTreino.getInstance().getListaAtividades();
        String atividadeParaLista = null;

        if (nTreino != null || oTreino != null) {
            nomeTreino.setText(nTreino);
            objTreino.setText(oTreino);
        }

        if (atividades != null) {
            for (Atividade a : atividades) {
                if (atividadeParaLista == null) {
                    atividadeParaLista = "- " + a.getNomeAtividade() + "\n";
                } else {
                    atividadeParaLista = atividadeParaLista + "- " + a.getNomeAtividade() + "\n";
                }
            }

            //Apresentar dados da lista na tela do treino.
            listaAtividadesTreino.setText(atividadeParaLista);

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

    public void adicionarAtividade(View v) {

        //Receber a instância desta classe e armazenar para enviar por Intent
        ControllerCadastroTreino.getInstance().setNomeTreino(nomeTreino.getText().toString());
        ControllerCadastroTreino.getInstance().setObjTreino(objTreino.getText().toString());
        ControllerCadastroTreino.getInstance().setListaAtividades(atividades);
        //Envia instância da classe por Intent
        Intent i = new Intent(CadastroTreino.this, CadastroAtividades.class);
        startActivity(i);
        finish();
    }

    public void salvarTreino(View v) {

        String nT = nomeTreino.getText().toString();
        String oT = objTreino.getText().toString();
        String aT;
        StringBuffer strBuffer = new StringBuffer();

        ArrayList<Atividade> alAtv = (ArrayList) ControllerCadastroTreino.getInstance().getListaAtividades();

        if (alAtv != null) {
            for (Atividade a : atividades) {
                strBuffer.append(a);
            }
            aT = strBuffer.toString();
        } else {
            aT = "";
        }


        Treino tr = new Treino(nT, oT, aT);
        tr.save();
        Toast.makeText(this, "Treino CADASTRADO com SUCESSO", Toast.LENGTH_LONG).show();

        Intent i = new Intent(CadastroTreino.this, Main2Activity.class);
        startActivity(i);
    }

}
