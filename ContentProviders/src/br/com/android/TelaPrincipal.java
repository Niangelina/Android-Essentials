package br.com.android;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog.Calls;
import android.util.Log;

public class TelaPrincipal extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
     // Criação de uma URI que serve para indicar o que queremos que seja
     		// chamado pela intent
     		Uri allCalls = Uri.parse("content://call_log/calls");

     		//Cursor que retorna a Query no nosso caso usa a nossa URI 
     		Cursor c = managedQuery(allCalls, null, null, null, null);

     		//if que verifica quantos contatos estão no aparelho
     		if (c.moveToFirst()) {
     			do {
     				String callType = "";
     				//aqui pega os contatos  pelo tipo
     				switch (Integer.parseInt(c.getString(c.getColumnIndex(Calls.TYPE)))) {
     				case 1:
     					callType = "Chamada Recebida";
     					break;
     				case 2:
     					callType = "Chamada Feita";
     					break;
     				case 3:
     					callType = "Chamada Perdida";
     				}
     				
     				//Log para jogar no LogCat o resultado de nossa pesquisa
     				Log.v("Content Providers",
     						c.getString(c.getColumnIndex(Calls._ID))
     								+ ", "
     								+ c.getString(c.getColumnIndex(Calls.NUMBER))
     								+ ", "
     								+ c.getString(c
     										.getColumnIndex(Calls.CACHED_NAME))
     								+ ", " + callType);
     			//simples while para continuar veridicando
     			} while (c.moveToNext());
     		}
     	}
     }