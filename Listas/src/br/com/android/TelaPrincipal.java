package br.com.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TelaPrincipal extends ListActivity {
    
	private String[] lstFrutas;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Criar um array de Strings, que será utilizado em seu ListActivity
		lstFrutas = new String[] { "Banana", "Pera", "Maça", "Abacaxi",
				"Melancia", "Pitanga", "Laranja", "Goiaba"};

		// Criar um ArrayAdapter, que vai fazer aparecer as Strings acima
		// em seu ListView
		this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lstFrutas));

	}

	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
		case 0:
			//Faz Alguma coisa se selecionar o primeiro item da lista
			AlertDialog.Builder dialogo = new AlertDialog.Builder(TelaPrincipal.this);
			dialogo.setTitle("Frutas"); 
			dialogo.setMessage("Você Selecionou: Banana"); 
			dialogo.setNeutralButton("OK", null);
			dialogo.show();
			break;
		case 1:
			Toast.makeText(getApplicationContext(), "Você Selecionou Pera" , Toast.LENGTH_SHORT).show();
			break;
		case 2:
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(TelaPrincipal.this);
			dialogo1.setTitle("Frutas"); 
			dialogo1.setMessage("Você Selecionou: Maça"); 
			dialogo1.setNeutralButton("OK", null);
			dialogo1.show();

			break;
		case 3:
			Toast.makeText(getApplicationContext(), "Você Selecionou Abacaxi" , Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(getApplicationContext(), "Você Selecionou Melancia" , Toast.LENGTH_SHORT).show();
			break;
		case 5:
			Toast.makeText(getApplicationContext(), "Você Selecionou Pitanga" , Toast.LENGTH_SHORT).show();
			break;
		case 6:
			Toast.makeText(getApplicationContext(), "Você Selecionou Laranja" , Toast.LENGTH_SHORT).show();
			break;
		case 7:
			Toast.makeText(getApplicationContext(), "Você Selecionou Goiaba" , Toast.LENGTH_SHORT).show();
			break;
		}

	}

}