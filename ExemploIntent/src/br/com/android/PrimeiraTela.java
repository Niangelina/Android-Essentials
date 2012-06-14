package br.com.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PrimeiraTela extends Activity {
    /** Called when the activity is first created. */
	private Button chamaSegundaTela;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        chamaSegundaTela = (Button) findViewById(R.id.button1);
        
        chamaSegundaTela.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				startActivity(new Intent(PrimeiraTela.this, SegundaTela.class));
				
			}
		});
    }
}