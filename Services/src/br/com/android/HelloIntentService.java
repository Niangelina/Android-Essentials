package br.com.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloIntentService extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Intent helloIntentService = new Intent(this, NossoServico.class);
        Button btnStart = (Button) findViewById(R.id.button1);
        btnStart.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startService(helloIntentService);
			}
		});
        
        Button btnStop = (Button) findViewById(R.id.button2);
        btnStop.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				stopService(helloIntentService);
				
			}
		});
    }
}