package br.com.fourlinux.listas;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TelaPrincipal extends ListActivity {
	/** Called when the activity is first created. */

	private String[] lstFrutas;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Criar um array de Strings, que ser� utilizado em seu ListActivity
		lstFrutas = new String[] { "Banana", "Pera", "Ma�a", "Abacaxi",
				"Melancia", "Pitanga", "Laranja", "Goiaba"};

		// Criar um ArrayAdapter, que vai fazer aparecer as Strings acima
		// em seu ListView
		this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lstFrutas));

	}

	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
		case 0:
			//Faz Alguma coisa se selecionar o primeiro item da lista
			AlertDialog.Builder dialogo = new AlertDialog.Builder(TelaPrincipal.this);
			dialogo.setTitle("Frutas"); 
			dialogo.setMessage("Voc� Selecionou: Banana"); 
			dialogo.setNeutralButton("OK", null);
			dialogo.show();
			break;
		case 1:
			Toast.makeText(getApplicationContext(), "Voc� Selecionou Pera" , Toast.LENGTH_SHORT).show();
			break;
		case 2:
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(TelaPrincipal.this);
			dialogo1.setTitle("Frutas"); 
			dialogo1.setMessage("Voc� Selecionou: Ma�a"); 
			dialogo1.setNeutralButton("OK", null);
			dialogo1.show();

			break;
		case 3:
			Toast.makeText(getApplicationContext(), "Voc� Selecionou Abacaxi" , Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(getApplicationContext(), "Voc� Selecionou Melancia" , Toast.LENGTH_SHORT).show();
			break;
		case 5:
			Toast.makeText(getApplicationContext(), "Voc� Selecionou Pitanga" , Toast.LENGTH_SHORT).show();
			break;
		case 6:
			Toast.makeText(getApplicationContext(), "Voc� Selecionou Laranja" , Toast.LENGTH_SHORT).show();
			break;
		case 7:
			Toast.makeText(getApplicationContext(), "Voc� Selecionou Goiaba" , Toast.LENGTH_SHORT).show();
			break;
		}

	}

}
