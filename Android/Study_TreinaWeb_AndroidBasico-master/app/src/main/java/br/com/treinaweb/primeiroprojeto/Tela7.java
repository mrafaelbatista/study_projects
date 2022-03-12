package br.com.treinaweb.primeiroprojeto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Tela7 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela7);

        String[] cursos = getResources().getStringArray(R.array.cursos);
        ArrayAdapter<String> aAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, cursos);

        Spinner spnCursos = (Spinner) findViewById(R.id.spinnerCursos);
        spnCursos.setAdapter(aAdapter);

        Button btnOk = (Button) findViewById(R.id.buttonOk);
        btnOk.setOnClickListener(clickListener);
    }

    private OnClickListener clickListener = new OnClickListener(){

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            TextView resposta = (TextView) findViewById(R.id.textViewResposta);
            Spinner spnCursos = (Spinner) findViewById(R.id.spinnerCursos);

            String msg = " Curso selecionado: ";
            msg += ((TextView) spnCursos.getSelectedView()).getText().toString();
            resposta.setText(msg);
        }
    };
}