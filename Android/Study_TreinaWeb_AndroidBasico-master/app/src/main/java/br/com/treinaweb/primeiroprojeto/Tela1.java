package br.com.treinaweb.primeiroprojeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Tela1 extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tela1);

      Button btn = (Button) findViewById(R.id.buttonProximo);
      btn.setOnClickListener(clickListener);
  }

  private OnClickListener clickListener = new OnClickListener() {

	  @Override
	  public void onClick(View v) {
	    // TODO Auto-generated method stub
	    Intent intencao = new Intent(Tela1.this, Tela2.class);
	    EditText txtNome = (EditText) findViewById(R.id.editTextNome);

	    String nome = txtNome.getText().toString();

	    Bundle parametros = new Bundle();
	    parametros.putString("nome", nome);

	    intencao.putExtras(parametros);

	    startActivity(intencao);
	  }
//	  
//    @Override
//    public void onClick(View arg0) {
//      // TODO Auto-generated method stub
//      TextView tvResultado = (TextView) findViewById(R.id.textViewResposta);
//      EditText txtNome = (EditText) findViewById(R.id.editTextNome);
//
//      String msg = "Nome: " + txtNome.getText().toString();
//      tvResultado.setText(msg);
//    }
  };
}
