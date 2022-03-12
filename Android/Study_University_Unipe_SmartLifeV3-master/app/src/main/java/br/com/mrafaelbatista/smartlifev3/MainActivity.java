package br.com.mrafaelbatista.smartlifev3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import br.com.mrafaelbatista.smartlifev3.auxiliar.Constants;
import br.com.mrafaelbatista.smartlifev3.connection.volley.requests.LoginRequest;
import br.com.mrafaelbatista.smartlifev3.models.DadosLogin;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener {

    //Atributos de UI
    private EditText et_login;
    private EditText et_password;
    private CheckBox cb_manterConectado;
    private ProgressDialog progress;
    private View vBack;

    //Atributos para o volley
    private String url;

    //Instância de Dados Login
    DadosLogin dadosLogin = new DadosLogin();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Pega o fundo e adiciona um valor de Alpha
        vBack = findViewById(R.id.lay_contentMain);
        vBack.getBackground().setAlpha(90);

        //Busca dos dados do Layout
        et_login = (EditText) findViewById(R.id.loginAut);
        et_password = (EditText) findViewById(R.id.senhaAut);
        cb_manterConectado = (CheckBox) findViewById(R.id.conectAut);

        //Carregamento do ProgressDialog
        progress = new ProgressDialog(this);
        progress.setMessage("Autenticando...");

        //Verificar Token
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String prefTeste = pref.getString(Constants.TOKEN, null);
        if (prefTeste != null) {
            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(i);
            finish();
        }

    }

    public void autenticarLogin(View v) {
        progress.show();

        String login = et_login.getText().toString();
        String pass = et_password.getText().toString();

        url = "https://www.eukip.com/aulas/getusuario.aspx?login=" + login + "&senha=" + pass;
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.requestImageGet(MainActivity.this, MainActivity.this, url);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        progress.dismiss();
        Toast.makeText(MainActivity.this, "Você NÃO está CONECTADO!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(Object response) {
        progress.dismiss();

        Gson gson = new Gson();
        dadosLogin = gson.fromJson(response.toString(), DadosLogin.class);
        Toast.makeText(MainActivity.this, "Status " + dadosLogin.getStatus(), Toast.LENGTH_LONG).show();

        if (!(dadosLogin.getToken().isEmpty())) {

            if (cb_manterConectado.isChecked()) {
                //Salvar no Shared Preferences
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(Constants.TOKEN, dadosLogin.getToken().toString());
                editor.putString(Constants.MANTER_CONECTADO, String.valueOf(cb_manterConectado.isChecked()));
                editor.commit();
            }

            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(i);
            finish();
        }
    }


}
