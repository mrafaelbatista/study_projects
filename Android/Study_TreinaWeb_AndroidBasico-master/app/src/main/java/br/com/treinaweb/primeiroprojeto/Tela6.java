package br.com.treinaweb.primeiroprojeto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class Tela6 extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tela6);

    //String[] cursos = getResources().getStringArray(R.array.cursos);
    String[] cursos = {"Android Basico", "Java Basico", "C# Basico"};
    ArrayAdapter<String> aAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, cursos);

    ListView list = (ListView) findViewById(R.id.listViewCursos);
    list.setAdapter(aAdapter);

    list.setOnItemClickListener(itemClickListener);
  }

  private OnItemClickListener itemClickListener = new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
        long id) {
      // TODO Auto-generated method stub
      TextView resposta = (TextView) findViewById(R.id.textViewResposta);
        String curso = ((TextView) view).getText().toString();

        resposta.setText("Resposta: " + curso);
    }
  };
}

////Carregando via c�digo
//public class Tela6 extends Activity {
//
//	   @Override
//	   protected void onCreate(Bundle savedInstanceState) {
//	     super.onCreate(savedInstanceState);
//	     setContentView(R.layout.activity_tela6);
//
//	     //String[] cursos = getResources().getStringArray(R.array.cursos);
//	     String[] cursos = {"Android B�sico", "Java B�sico", "C# B�sico"};
//	     ArrayAdapter<String> aAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, cursos);
//
//	     ListView list = (ListView) findViewById(R.id.listViewCursos);
//	     list.setAdapter(aAdapter);
//	   }
//	}

//Carregando via arquivo String
//public class Tela6 extends Activity {
//
//   @Override
//   protected void onCreate(Bundle savedInstanceState) {
//     super.onCreate(savedInstanceState);
//     setContentView(R.layout.activity_tela6);
//
//     String[] cursos = getResources().getStringArray(R.array.cursos);
//     ArrayAdapter<String> aAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, cursos);
//
//     ListView list = (ListView) findViewById(R.id.listViewCursos);
//     list.setAdapter(aAdapter);
//   }
//}