package br.com.fourlinux.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneMode extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
			Toast.makeText(context, "Quando voc� clicou no AirPlane Mode sua Aplica��o capturou essa a��o", Toast.LENGTH_LONG).show();
		}
		
	}

}
