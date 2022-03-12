package br.com.mrafaelbatista.smartlifev3.connection.volley.requests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import br.com.mrafaelbatista.smartlifev3.DietaActivity;
import br.com.mrafaelbatista.smartlifev3.MainActivity;
import br.com.mrafaelbatista.smartlifev3.connection.volley.ApplicationController;

public class DietaRequest {

	private static final String URL =
	"http://mrafaelbatista.com.br/android_json/";

	private String resultRequest;

	public void requestImageGet(DietaActivity main,  final Context context, String urlAcesso){

		//Conexão com serviço usando Volley
		RequestQueue queue = Volley.newRequestQueue(context);

		/**
		 * Parametros de recebimento
		 * @param metodo de requisição POST OU GET
		 * @param metodo de requisição URL do Serviço
		 * @param metodo de requisição Interface de tratamento de erro
		 * @param metodo de requisição Interface para sucesso
		 */
		StringRequest getRequest = new StringRequest(Request.Method.GET, urlAcesso, main, main);
		ApplicationController.getInstance().addToRequestQueue(getRequest);

	}
	
	public void requestImagePost(DietaActivity main,  final Context context, String urlAcesso){

		//Conexão com servço usando Volley
		RequestQueue queue = Volley.newRequestQueue(context);

		/**
		 * Parametros de recebimento
		 * @param metodo de requisição POST OU GET
		 * @param metodo de requisição URL do Serviço
		 * @param metodo de requisição Interface de tratamento de erro
		 * @param metodo de requisição Interface para sucesso
		 */
		StringRequest postRequest = new StringRequest(Request.Method.POST, urlAcesso, main, main) {
			@Override
			protected Map<String, String> getParams()
			{
				Map<String, String> params = new HashMap<String, String>();
				params.put("param", "valor");
				params.put("param", "valor");

				return params;
			}
		};
		queue.add(postRequest);
	}

	public boolean jsonResult(Context context, String result){
		//TRATAMENTO DO JSON DE RETORNO
		return false;
	}
}
