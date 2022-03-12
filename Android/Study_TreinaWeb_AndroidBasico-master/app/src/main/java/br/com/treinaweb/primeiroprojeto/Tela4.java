package br.com.treinaweb.primeiroprojeto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;


public class Tela4 extends Activity{

	public void onCreate(Bundle savedInstanceState){
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_tela4);

	    Button btnOk = (Button) findViewById(R.id.buttonOk);
	    btnOk.setOnClickListener(clickListener);

	    CheckBox chkAndroid = (CheckBox) findViewById(R.id.checkBoxAndroidBasico);
	    CheckBox chkJava = (CheckBox) findViewById(R.id.checkBoxJavaBasico);
	    CheckBox chkCSharp = (CheckBox) findViewById(R.id.checkBoxCSharpBasico);

	    chkAndroid.setOnCheckedChangeListener(checkedChangeListener);
	    chkJava.setOnCheckedChangeListener(checkedChangeListener);
	    chkCSharp.setOnCheckedChangeListener(checkedChangeListener);
	}
	
	  private OnClickListener clickListener = new OnClickListener(){

		    @Override
		    public void onClick(View arg0) {
		      // TODO Auto-generated method stub
		        TextView resposta = (TextView) findViewById(R.id.textViewResposta);
		        CheckBox chkAndroid = (CheckBox) findViewById(R.id.checkBoxAndroidBasico);
		        CheckBox chkJava = (CheckBox) findViewById(R.id.checkBoxJavaBasico);
		        CheckBox chkCSharp = (CheckBox) findViewById(R.id.checkBoxCSharpBasico);

		        String msg = "Curso(s) selecionado(s): ";
		        if(chkAndroid.isChecked())
		          msg += chkAndroid.getText().toString() + " ";
		        if(chkJava.isChecked())
		          msg += chkJava.getText().toString() + " ";
		        if(chkCSharp.isChecked())
		          msg += chkCSharp.getText().toString() + " ";

		        resposta.setText(msg);
		    }

		  };
	

	private OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener(){

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		 TextView resposta = (TextView) findViewById(R.id.textViewResposta);
		        if(isChecked)
		          resposta.setText("Curso: " + ((CheckBox) buttonView).getText() + " selecionado!");
		        else
		          resposta.setText("Curso: " + ((CheckBox) buttonView).getText() + " não está selecionado!");
		  }
	};


}