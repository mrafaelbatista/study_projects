package br.com.treinaweb.primeiroprojeto;

/**
 * Created by messias on 27/01/15.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Tela8 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela8);
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela8);
    } */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        final TextView tvResposta = (TextView) findViewById(R.id.textViewResposta);
        String msg = "";
        switch (item.getItemId()) {
            case R.id.menu_archive:
                String texto = "Selecionada a opção Arquivo";
                Context context = getApplicationContext();
                int duracao = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, texto, duracao);
                toast.show();
                break;

            /*case R.id.menu_archive:
                AlertDialog.Builder mBox = new AlertDialog.Builder(this);
                mBox.setMessage("Selecionado a opção Arquivo");
                mBox.setTitle("Arquivo");
                mBox.setIcon(R.drawable.ic_menu_archive);
                mBox.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvResposta.setText("Botão Clicado");
                    }
                });
                mBox.show();
                break;

            case R.id.menu_edit:
                msg = "Selecionada a opção Editar";
                break;
            case R.id.menu_save:
                msg = "Selecionada a opção Salvar";
                break;
            case R.id.menu_home:
                msg = "Selecionada a opção Home";
                break;
            case R.id.menu_delete:
                excluirCadastro();
                break;
                        /* case R.id.menu_more:
                            msg = "Selecionada a opção Mais";
                            break;
            case R.id.menu_search:
                msg = "Selecionada a opção Pesquisar";
                break;
            case R.id.menu_attachment:
                msg = "Selecionada a opção Adicionar arquivo";
                break;
            case android.R.id.home;
                msg = "Selecionado o ícone da aplicação";
                break; */
        }

        tvResposta.setText(msg);
        return true;
    }

    //MÉTODOS A SEREM UTILIZADOS
    private void excluirCadastro() {
        final TextView tvResposta = (TextView) findViewById(R.id.textViewResposta);
        AlertDialog.Builder mBox = new AlertDialog.Builder(this);
        mBox.setMessage("Deseja excluir o cadastro selecionado");
        mBox.setTitle("Excluir cadastro");
        mBox.setIcon(R.drawable.ic_menu_delete);
        mBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                tvResposta.setText("Botão Sim clicado");
            }
        });
        mBox.setNegativeButton("Não", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                tvResposta.setText("Botão Não clicado");
            }
        });
        mBox.show();
    }
}