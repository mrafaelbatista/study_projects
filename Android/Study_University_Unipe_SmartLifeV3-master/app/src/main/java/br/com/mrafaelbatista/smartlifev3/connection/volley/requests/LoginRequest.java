package br.com.mrafaelbatista.smartlifev3.connection.volley.requests;

import android.content.Context;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import br.com.mrafaelbatista.smartlifev3.MainActivity;
import br.com.mrafaelbatista.smartlifev3.connection.volley.ApplicationController;

public class LoginRequest {

	private static final String URL =
	"https://www.eukip.com/aulas/getusuario.aspx?";

	private String resultRequest;

	public void requestImageGet(MainActivity main,  final Context context, String urlteste){

		//Conexão com serviço usando Volley
		RequestQueue queue = Volley.newRequestQueue(context);

		/**
		 * Parametros de recebimento
		 * @param metodo de requisição POST OU GET
		 * @param metodo de requisição URL do Serviço
		 * @param metodo de requisição Interface de tratamento de erro
		 * @param metodo de requisição Interface para sucesso
		 */
		StringRequest getRequest = new StringRequest(Request.Method.GET, urlteste, main, main);
		ApplicationController.getInstance().addToRequestQueue(getRequest);

	}
	
	public void requestImagePost(MainActivity main,  final Context context){

		//Conexão com servço usando Volley
		RequestQueue queue = Volley.newRequestQueue(context);

		/**
		 * Parametros de recebimento
		 * @param metodo de requisição POST OU GET
		 * @param metodo de requisição URL do Serviço
		 * @param metodo de requisição Interface de tratamento de erro
		 * @param metodo de requisição Interface para sucesso
		 */
		StringRequest postRequest = new StringRequest(Request.Method.POST,URL, main, main) {
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
