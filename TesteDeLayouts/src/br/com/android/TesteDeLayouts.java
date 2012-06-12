package br.com.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TesteDeLayouts extends Activity {
    /** Called when the activity is first created. */
	
	private Button btnTeste;
	private EditText edtTexto;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnTeste = (Button) findViewById(R.id.btnAcao);
        edtTexto = (EditText) findViewById(R.id.textNome);
        
        btnTeste.setOnClickListener(new OnClickListener() {
			
        	public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), edtTexto.getText(), Toast.LENGTH_LONG).show();
			}
		});
    }
}